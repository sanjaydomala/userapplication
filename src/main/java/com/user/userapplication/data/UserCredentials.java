package com.user.userapplication.data;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Data
@Table(name = "User")
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private UUID userId;

    @NotBlank(message = "Username must not be blank")
    @Size(min = 6, max = 16, message = "Username must be between 6 and 16 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Username must consist of letters, numbers, underscore, or hyphen only")
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password; // Consider encrypting passwords!


    // Getters and Setters
}
