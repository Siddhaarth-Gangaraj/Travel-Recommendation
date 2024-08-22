package com.epam.travelrecommendation.controller;

import com.epam.travelrecommendation.model.User;
import com.epam.travelrecommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User registeredUser = userService.registerUser(user);
//        System.out.println(registeredUser.getPassword());
//        return ResponseEntity.ok(registeredUser);
//    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        Optional<User> registeredUser = userService.registerUser(user);
        if (!registeredUser.isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use");
        }
        return ResponseEntity.ok(registeredUser.get());
    }
}
