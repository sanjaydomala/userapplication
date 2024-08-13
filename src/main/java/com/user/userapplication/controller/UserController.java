package com.user.userapplication.controller;

import com.user.userapplication.data.UserProfile;
import com.user.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-profile")
    public UserProfile createUserProfile(@RequestBody @Valid UserProfile userProfile) {
        return userService.createUserProfile(userProfile);
    }

    @GetMapping("/userprofiles")
    public List<UserProfile> getAllUserProfiles(){
        return userService.getAllUserProfiles();
    }

    @GetMapping("user-profile/{id}")
    public UserProfile getUserProfileById(@PathVariable UUID id){
        return userService.getUserProfileById(id);
    }

    @PutMapping("/update-profile")
    public UserProfile updateUser(@RequestBody UserProfile userProfile) {
        return userService.updateUserProfile(userProfile);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return userId+"deleted successfully";
    }
}
