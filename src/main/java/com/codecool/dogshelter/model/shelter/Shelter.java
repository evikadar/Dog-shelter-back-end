package com.codecool.dogshelter.model.shelter;

import com.codecool.dogshelter.model.dog.Dog;
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

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;

    @OneToMany(mappedBy = "shelter", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Singular
    @EqualsAndHashCode.Exclude
    private List<Dog> dogs;
}
