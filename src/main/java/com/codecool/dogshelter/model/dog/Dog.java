package com.codecool.dogshelter.model.dog;

import com.codecool.dogshelter.model.shelter.Shelter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JsonIgnoreProperties({"dog"})
    private DogDescription description;

    private String photoPath;
    private boolean isNeutered;

    @ManyToOne
    @JsonIgnoreProperties({"dogs"})
    private Shelter shelter;

    @Enumerated(EnumType.STRING)
    private Breed breed;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private DogSize size;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JsonIgnoreProperties({"dog"})
    private Owner owner;


    public Long getAge() {

        if (dateOfBirth != null) {
            return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
        }
        return null;
    }
}
