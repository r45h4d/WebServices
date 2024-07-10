package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {
   Map<String, User> users = new HashMap<>();
    public void createUser(User user) {
        UUID uuid = UUID.randomUUID();
        user.id = String.valueOf(uuid);
        users.put(user.id, user);
    }

    public void updateUser(String id, Integer newAge){
        if(users.containsKey(id)){
            User user = users.get(id);
            user.setAge(newAge);
            users.replace(id, user);
        }
    }

    public List<User> getUsersByAge(int fromAge, int toAge) {
        List<User> userList = new ArrayList<>();
        for (User user : users.values()) {
            if (user.getAge() >= fromAge && user.getAge() <= toAge) {
                userList.add(user);
            }
        }
        return userList;
    }
}
