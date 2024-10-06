package com.users.users.controller;

import com.users.users.model.domain.Activity;
import com.users.users.model.domain.User;
import com.users.users.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/appActivitats/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.creatUser(user);
        return ResponseEntity.ok("USER CREATED");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id,@RequestBody User user){
        userService.updateUser(id,user);
        return ResponseEntity.ok("USER UPDATED");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>>readUser(@PathVariable Long id){
        Optional<User> user = userService.readUser(id);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("USER DELETED");
    }
}
