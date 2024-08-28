package com.user.userapplication.service;

import com.user.userapplication.data.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {


    List<UserProfile> findByGenderInAndProfessionIn(List<String> gender,List<String> professions);

    //List<UserProfile> findByAllFiltersByFields(String )
}
