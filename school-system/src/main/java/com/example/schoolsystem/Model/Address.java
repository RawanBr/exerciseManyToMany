package com.example.schoolsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Address {

    @Id
    private Integer id;

    private String area;

    private String street;

    private Integer buildingNumber;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Teacher teacher;
}
