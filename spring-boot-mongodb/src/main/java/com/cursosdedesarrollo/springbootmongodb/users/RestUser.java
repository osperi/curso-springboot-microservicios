package com.cursosdedesarrollo.springbootmongodb.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestUser {

    @Autowired
    private UserRepository repository;

    @GetMapping("/user")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/user")
    User newUser(@RequestBody User user) {
        return repository.save(user);
    }

    @GetMapping("/user/{id}")
    User one(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User replaceUser(@RequestBody User user, @PathVariable String id) {

        return repository.findById(id)
                .map(user1 -> {
                    user1.setName(user.getName());
                    user1.setEmail(user.getEmail());
                    user1.setPassword(user.getPassword());
                    user1.setActivo(user.isActivo());
                    user1.setToken(user.getToken());
                    user1.setGroups(user.getGroups());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    return repository.save(user);
                });
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable String id) {
        repository.deleteById(id);
    }
}
