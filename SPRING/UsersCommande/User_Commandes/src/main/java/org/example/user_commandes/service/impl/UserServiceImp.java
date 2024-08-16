package org.example.user_commandes.service.impl;

import org.example.user_commandes.dto.UserDto;
import org.example.user_commandes.entity.User;
import org.example.user_commandes.repository.UserRepository;
import org.example.user_commandes.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService<User, UserDto> {


    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto entite) {
        return transformEntityAtDTO( userRepository.save(transformDtoatEntity(entite)));
    }

    @Override
    public UserDto findUserById(long id) {
        return transformEntityAtDTO(userRepository.getReferenceById(id));
    }

    @Override
    public User transformDtoatEntity(UserDto entite) {
        return new User(entite.getId(), entite.getEmail(), entite.getName());
    }

    @Override
    public UserDto transformEntityAtDTO(User enity) {
        return new UserDto(enity.getId(), enity.getName(), enity.getEmail());
    }
}
