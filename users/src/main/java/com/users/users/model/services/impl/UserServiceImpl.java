package com.users.users.model.services.impl;

import com.users.users.model.domain.User;
import com.users.users.model.repository.UserRepository;
import com.users.users.model.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public void creatUser(User user) {
        if(user.getName() == null || user.getName().isBlank()){
            throw new RuntimeException("NAME CANNOT BY EMPTY");
        }
        if(user.getLastname() == null || user.getLastname().isBlank()){
            throw new RuntimeException("LASTNAME CANNOT BE EMPTY");
        }
        if(user.getEmail() == null || user.getEmail().isBlank()){
            throw new RuntimeException("EMAIL CANNOT BE EMPTY");
        }
        userRepository.findByEmail(user.getEmail())
                .ifPresent(usr ->{
                    throw new RuntimeException("EMAIL NOT AVAILABLE");
                } );
        var usr = User.builder()
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
        userRepository.save(usr);
    }

    @Override
    public Optional<User> readUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("USER NOT FOUND"));
        return userRepository.findById(id);

    }
    @Override
    public User updateUser(long id, User user) {
        User updUser = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("USER NOT FOUND"));
        updUser.setName(user.getName());
        updUser.setLastname(user.getLastname());
        return userRepository.save(updUser);

    }
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
