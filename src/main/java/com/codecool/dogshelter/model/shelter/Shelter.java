package com.codecool.dogshelter.model.shelter;

import com.codecool.dogshelter.model.dog.Dog;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Shelter {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;
    private String phoneNumber;
    private String photoPath;
    private String shelterDescription;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties({"shelter"})
    private Address address;

    @OneToMany(mappedBy = "shelter", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @Singular
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties({"shelter"})
    private List<Dog> dogs;
}
