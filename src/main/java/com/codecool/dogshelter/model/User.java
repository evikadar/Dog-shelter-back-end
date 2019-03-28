package com.codecool.dogshelter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @GeneratedValue
    @Id
    private Long id;

    private String username;
    private String email;
    // TODO: there should be only one password and it should be validated by react on the frontend!
    // TODO: hash everything
    private String password1;
    private String password2;



}
