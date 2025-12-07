package com.example.schoolsystem.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "Teacher ID cannot be empty")
    private Integer teacherId;

    @NotEmpty(message = "Area cannot be empty")
    private String area;

    @NotEmpty(message = "Street cannot be empty")
    private String street;

    @NotNull(message = "Building Number cannot be empty")
    private Integer buildingNumber;
}
