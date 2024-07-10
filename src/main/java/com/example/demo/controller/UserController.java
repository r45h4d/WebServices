package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsersByAge(@RequestParam(name = "ageFrom") int ageFrom, @RequestParam(name = "ageTo") int ageTo) {
        return userService.getUsersByAge(ageFrom, ageTo);
    }

    @PatchMapping
    public void updateUserAge(@RequestParam(name="id") String id, @RequestParam(name="newAge") Integer newAge){
        userService.updateUser(id, newAge);
    }
}
