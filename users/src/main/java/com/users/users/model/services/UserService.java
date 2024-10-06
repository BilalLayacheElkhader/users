package com.users.users.model.services;

import com.users.users.model.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    void creatUser(User user);
    Optional<User> readUser(long id);
    User updateUser(long id, User user);
    void deleteUser(long id);

}
