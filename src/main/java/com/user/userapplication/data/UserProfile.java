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
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserCredentials userCredentials;

    @NotBlank(message = "Full name is required")
    @Size(min = 6, max = 50, message = "Full name must be between 2 and 100 characters")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private Date dateOfBirth;

    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String profession;
    private Integer experienceYears;
    private String description;
    private String companyName;
    private String companyLicenseNo;
    private String establishedDate;
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Embedded
    private Address address;
    private List<String> workExperienceDetails;
}
