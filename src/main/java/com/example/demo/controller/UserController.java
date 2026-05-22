package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<String> users = new ArrayList<>(
            Arrays.asList("Shanthi", "Ravi", "Kiran")
    );

    // GET API
    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id) {

        if (id >= users.size()) {
            return "User Not Found";
        }

        return users.get(id);
    }

    // POST API
    @PostMapping
    public String addUser(@RequestBody String name) {
        users.add(name);
        return "User Added Successfully";
    }

    // PUT API
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id,
                             @RequestBody String name) {

        if (id >= users.size()) {
            return "User Not Found";
        }

        users.set(id, name);

        return "User Updated Successfully";
    }

    // DELETE API
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {

        if (id >= users.size()) {
            return "User Not Found";
        }

        users.remove(id);

        return "User Deleted Successfully";
    }
}