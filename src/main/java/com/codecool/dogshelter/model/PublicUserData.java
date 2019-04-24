package com.codecool.dogshelter.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PublicUserData {

    private String username;
    private boolean loggedIn;
    private UserRole userRole;


}
