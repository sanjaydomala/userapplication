package com.user.userapplication.controller;

import com.user.userapplication.data.UserCredentials;
import com.user.userapplication.data.UserProfile;
import com.user.userapplication.service.UserService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserCredentials createUser(@RequestBody @Valid UserCredentials user) {
        return userService.createUser(user);
    }

    @PostMapping("/add-profile")
    public UserProfile createUserProfile(@RequestBody @Valid UserProfile userProfile) {
        return userService.createUserProfile(userProfile);
    }

    @GetMapping
    public List<UserCredentials> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/userprofile")
    public List<UserProfile> getAllUserProfiles(){
        return userService.getAllUserProfiles();
    }

    @GetMapping("user/{id}")
    public UserCredentials getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping("user-profile/{id}")
    public UserProfile getUserProfileById(@PathVariable UUID id){
        return userService.getUserProfileById(id);
    }

    @PutMapping("/update-profile")
    public UserProfile updateUser(@RequestBody UserProfile userProfile) {
        return userService.updateUserProfile(userProfile);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return id+"deleted successfully";
    }
}
