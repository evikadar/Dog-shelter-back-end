package com.codecool.dogshelter.model.dog;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DogDescription {

    @GeneratedValue
    @Id
    private Long id;

    private String personalityTrait;
    private String dreamHome;
    private String specialFeatures;

    @OneToOne(mappedBy = "description")
    @EqualsAndHashCode.Exclude
    private Dog dog;
}
