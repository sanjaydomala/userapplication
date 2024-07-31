package com.user.userapplication.service;

import com.user.userapplication.data.UserCredentials;
import com.user.userapplication.data.UserProfile;
import com.user.userapplication.exception.UserNameAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@EnableCaching
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Cacheable(value = "UserCredentials", key = "#userId", condition = "#userId!=null")
    public UserCredentials createUser(UserCredentials user) {
       boolean existedUserName =  userRepository.findAll().stream().anyMatch(userCredentials->userCredentials.getUsername()
                .equals(user.getUsername()));
       if(existedUserName){
           throw new UserNameAlreadyExist();
       }
        return userRepository.save(user);
    }

    public List<UserCredentials> getAllUsers() {
        return userRepository.findAll();
    }

    @Cacheable(value = "UserCredentials", key = "#userId", condition = "#userId!=null")
    public UserCredentials getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(()->
                new NoSuchElementException("user id is not found ::"+id));
    }

    public UserProfile updateUserProfile(UserProfile userProfile) {
        UserProfile updateUserProfile = userProfileRepository.findById(userProfile.getProfileId())
                .orElseThrow(() -> new NoSuchElementException("User id is not found"));
        updateUserProfile.setCompanyName(userProfile.getCompanyName());
        updateUserProfile.setDescription(userProfile.getDescription());
        updateUserProfile.setEmail(userProfile.getEmail());
        updateUserProfile.setCompanyLicenseNo(userProfile.getCompanyLicenseNo());
        updateUserProfile.setExperienceYears(userProfile.getExperienceYears());
        updateUserProfile.setPhoneNumber(userProfile.getPhoneNumber());
        updateUserProfile.setWorkExperienceDetails(userProfile.getWorkExperienceDetails());
        updateUserProfile.setEstablishedDate(userProfile.getEstablishedDate());
        updateUserProfile.setProfession(userProfile.getProfession());
        updateUserProfile.setDateOfBirth(userProfile.getDateOfBirth());
        return userProfileRepository.save(updateUserProfile);
    }

    @Cacheable(value = "UserCredentials", key = "#userId")
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
        userProfileRepository.deleteById(id);
    }

    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public List<UserProfile> getAllUserProfiles() {
       return userProfileRepository.findAll();
    }

    public UserProfile getUserProfileById(UUID id) {
       return userProfileRepository.getReferenceById(id);
    }
}
