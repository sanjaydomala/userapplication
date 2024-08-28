package com.user.userapplication.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "Profile")
public class UserProfile implements Serializable {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profileId", nullable = false)
    @NotNull
    private UUID profileId;
    @NotNull
    private String fullName;
    @NotNull
    @Column(insertable=false, updatable=false)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact  contact;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String profession;
    private Integer experienceYears;
    private String summary;
    @OneToOne(cascade = CascadeType.ALL)
    private CompanyProfile companyProfile;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private List<String> workExperienceDetails;
}
