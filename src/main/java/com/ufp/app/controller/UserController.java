package com.ufp.app.controller;

import com.ufp.app.model.user.User;
import com.ufp.app.model.user.enums.Gender;
import com.ufp.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-ufp/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }
    @PostMapping
    public User createOrUpdateUser(@RequestParam("firstname") String firstname,
                                   @RequestParam("lastname") String lastname,
                                   @RequestParam("role") String role,
                                   @RequestParam("age") int age,
                                   @RequestParam("gender") Gender gender,
                                   @RequestParam("image") MultipartFile image) throws IOException {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setRole(role);
        user.setAge(age);
        user.setGender(gender);
        user.setImage(image.getBytes());

        return userService.saveOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
