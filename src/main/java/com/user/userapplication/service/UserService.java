package com.user.userapplication.service;

import com.user.userapplication.data.UserProfile;
import com.user.userapplication.exception.UserNameAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile updateUserProfile(UserProfile userProfile) {
        UserProfile updateUserProfile = userProfileRepository.findById(userProfile.getProfileId())
                .orElseThrow(() -> new NoSuchElementException("User id is not found"));
        updateUserProfile.setSummary(userProfile.getSummary());
        updateUserProfile.setEmail(userProfile.getEmail());
        updateUserProfile.setExperienceYears(userProfile.getExperienceYears());
        updateUserProfile.setContact(userProfile.getContact());
        updateUserProfile.setWorkExperienceDetails(userProfile.getWorkExperienceDetails());
        updateUserProfile.setProfession(userProfile.getProfession());
        updateUserProfile.setDateOfBirth(userProfile.getDateOfBirth());
        return userProfileRepository.save(updateUserProfile);
    }

    //@CacheEvict(value = "UserCredentials", key = "#userId")
    public void deleteUser(UUID userId) {
        userProfileRepository.deleteById(userId);
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
