package org.example.service.impl;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserServiceImpl implements UserService<User, UserDto> {


    @Inject
    UserRepository userRepository;

    @Override
    public User dtoToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setAge(dto.getAge());
        return user;
    }

    @Override
    public UserDto entityToDto(User entity) {
        return new UserDto(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getEmail(), entity.getPassword(), entity.getAge());
    }

    @Override
    public User oldEntityToNewEntity(User oldEntity, User newEntity) {
        oldEntity.setId(newEntity.getId());
        oldEntity.setFirstname(newEntity.getFirstname());
        oldEntity.setPassword(newEntity.getLastname());
        oldEntity.setAge(newEntity.getAge());
        oldEntity.setEmail(newEntity.getEmail());
        oldEntity.setPassword(newEntity.getPassword());
        return oldEntity;
    }

    @Override
    public UserDto save(UserDto entity) {
        userRepository.persist(dtoToEntity(entity));
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public UserDto saveEntity(User entity) {
        userRepository.persist(entity);
        if (findByID(entity.getId()) == null)
            return null;
        return findByID(entity.getId());
    }

    @Override
    public UserDto update(long id, UserDto entity) {
        User oldUser = dtoToEntity(findByID(id));
        if (oldUser == null)
            return null;
        User book = oldEntityToNewEntity(oldUser, dtoToEntity(entity));
        return save(entityToDto(book));
    }

    @Override
    public boolean delete(long id) {
        if (findByID(id) == null)
            return false;
        return userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> findAll() {
        PanacheQuery<User> users = userRepository.findAll();
        List<UserDto> booksDto = new ArrayList<>();
        for (User book : users.list()) {
            booksDto.add(entityToDto(book));
        }
        return booksDto;
    }

    @Override
    public UserDto findByID(long id) {
        return entityToDto(userRepository.findById(id));
    }
}
