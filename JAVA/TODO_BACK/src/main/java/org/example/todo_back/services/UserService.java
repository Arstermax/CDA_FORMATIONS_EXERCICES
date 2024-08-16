package org.example.todo_back.services;

import org.example.todo_back.config.jwt.JwtTokenProvider;
import org.example.todo_back.dto.users.UserGetDto;
import org.example.todo_back.dto.users.UserPostDto;
import org.example.todo_back.models.UserEntity;
import org.example.todo_back.repository.UserRepository;
import org.example.todo_back.utils.EtatRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements BasesServices<UserGetDto, UserPostDto, UserEntity>, UserDetailsService, JwtServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public UserGetDto findBYId(long id) {
        return entityToGet(userRepository.getReferenceById(id));
    }
    public UserEntity findById(long id) {
        return (userRepository.getReferenceById(id));
    }

    @Override
    public List<UserGetDto> findAll() {
        List<UserEntity> users = userRepository.findAll();
        List<UserGetDto> userGetDtos = new ArrayList<>();
        for (UserEntity user : users) {
            userGetDtos.add(entityToGet(user));
        }
        return userGetDtos;
    }

    @Override
    public UserGetDto save(UserPostDto entity) {
        if (entity.getRoles() != null) {
            entity.setRoles(EtatRoles.ROLE_USER + "," + entity.getRoles());
        }else{
            entity.setRoles(EtatRoles.ROLE_USER.toString());
        }
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        return entityToGet(userRepository.save(postToEntity(entity)));
    }

    @Override
    public UserGetDto update(UserPostDto entity, long id) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        if (userEntity != null) {
            userRepository.save(postToEntity(entity));
        }
        return entityToGet(userRepository.getReferenceById(id));
    }

    @Override
    public String deleteById(long id) {
        userRepository.deleteById(id);
        return (userRepository.getReferenceById(id) == null ? "L' " + id + "à bien été supprimer" : "Error");
    }


    @Override
    public UserGetDto entityToGet(UserEntity entity) {
        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setId(entity.getId());
        userGetDto.setName(entity.getName());
        userGetDto.setEmail(entity.getEmail());
        return userGetDto;
    }



    @Override
    public UserEntity postToEntity(UserPostDto entity) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(entity.getName());
        userEntity.setEmail(entity.getEmail());
        userEntity.setRoles(entity.getRoles());
        userEntity.setPassword(entity.getPassword());
        return userEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    @Override
    public boolean verifyUser(String email, String password) {
        return userRepository.findByEmail(email).map(user -> passwordEncoder.matches(password, user.getPassword())).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    @Override
    public boolean checUserNameExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public String generateToken(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }
}
