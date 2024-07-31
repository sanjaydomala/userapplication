package com.user.userapplication.util;

import com.user.userapplication.data.UserProfile;

public class ProfileBuilder {

    public UserProfile limitedProfile(){
        return UserProfile.builder()
                .companyName("abc.com")
                .companyLicenseNo("123er45t")
                .build();
    }
}
