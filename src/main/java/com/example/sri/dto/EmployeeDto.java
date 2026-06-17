

        package com.example.sri.dto;



import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email
    private String email;




    @Positive
    private Double salary;
}