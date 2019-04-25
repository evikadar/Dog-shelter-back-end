package com.codecool.dogshelter.model.dog;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DogDescription {

    @GeneratedValue
    @Id
    private Long id;

    @Column(columnDefinition="CLOB(max)")
    private String personalityTrait;
    @Column(columnDefinition="CLOB(max)")
    private String dreamHome;
    @Column(columnDefinition="CLOB(max)")
    private String specialFeatures;

    @OneToOne(mappedBy = "description")
    @EqualsAndHashCode.Exclude
    private Dog dog;
}
