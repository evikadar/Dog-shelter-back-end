package com.codecool.dogshelter.model.dog;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Owner {

    @GeneratedValue
    @Id
    private Long id;

    private String email;

    private String name;

    private String phoneNumber;

    @OneToOne(mappedBy = "owner")
    @EqualsAndHashCode.Exclude
    private Dog dog;
}
