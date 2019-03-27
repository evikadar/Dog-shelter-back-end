package com.codecool.dogshelter.model.dog;

import com.codecool.dogshelter.model.Shelter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonIgnoreProperties({"dog"})
    private DogDescription description;

    private String photoPath;
    private boolean isNeutered;

    @ManyToOne
    @JsonIgnoreProperties({"dogs"})
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




}
