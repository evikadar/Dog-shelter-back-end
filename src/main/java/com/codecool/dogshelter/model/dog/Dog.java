package com.codecool.dogshelter.model.dog;

import com.codecool.dogshelter.model.Person;
import com.codecool.dogshelter.model.Shelter;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Dog {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private DogDescription description;

    private String photoPath;
    private boolean isNeutered;

    @ManyToOne
    private Shelter shelter;

    @Transient
    private int age;

    @Enumerated(EnumType.STRING)
    private Breed breed;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private DogSize size;

    @Enumerated(EnumType.STRING)
    private Status status;

    // private Person ownerCandidate;



}
