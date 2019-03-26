package com.codecool.dogshelter.model;

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

    @Column
    private String name;


    @OneToMany(mappedBy = "shelter", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Singular
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties({"shelter"})
    private List<Dog> dogs;





}
