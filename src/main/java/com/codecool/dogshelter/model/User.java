package com.codecool.dogshelter.model;

import com.codecool.dogshelter.model.shelter.Shelter;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    @GeneratedValue
    @Id
    private Long id;

    private String username;
    private String email;
    private String password1;
    private String selectedO;
    private UserRole userRole;

    @OneToOne(mappedBy = "user")
    private Shelter shelter;
}
