package com.example.schoolsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Teacher {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 21, message = "Age must be 21 and above")
    private Integer age;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "email format must be right")
    private String email;

    @NotNull(message = "salary cannot be empty")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;
}
