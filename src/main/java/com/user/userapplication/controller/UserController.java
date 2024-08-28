package com.user.userapplication.controller;

import com.user.userapplication.data.UserProfile;
import com.user.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    RestTemplate template;

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

    @GetMapping("/filterprofiles")
    public List<UserProfile> findByGenderAndProfession(@RequestParam List<String> gender, @RequestParam List<String> profession){
        return userService.findByGenderAndProfession(gender,profession);
    }

    @GetMapping("/getdistance")
    public Long getDistance(@RequestParam Long zipcode1,@RequestParam Long Zipcode2){

        String url = "http://localhost:8082/payments/get-payments";
        return  template.getForObject(url,Long.class);
    }
}
