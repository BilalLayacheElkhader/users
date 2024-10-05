package com.users.users.model.services.impl;

import com.users.users.model.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void creatUser(User user);
    void readUser(long id);
    void updateUser(long id, User user);
    void deleteUser(long id);

}
