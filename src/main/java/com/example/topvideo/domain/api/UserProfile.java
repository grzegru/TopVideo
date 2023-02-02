package com.example.topvideo.domain.api;

import java.time.LocalDateTime;

public class UserProfile {
    private String username;
    private String email;
    private LocalDateTime registrationDate;
    private int numberOfDiscoveriesAdded;

    public UserProfile(String username, String email, LocalDateTime registrationDate, int numberOfDiscoveriesAdded) {
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
        this.numberOfDiscoveriesAdded = numberOfDiscoveriesAdded;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public int getNumberOfDiscoveriesAdded() {
        return numberOfDiscoveriesAdded;
    }

}
