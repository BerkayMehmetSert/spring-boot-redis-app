package com.bms.springredisapp.dto;

import com.bms.springredisapp.model.Employee;

import java.io.Serializable;

public record EmployeeDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone
) implements Serializable {
    public static EmployeeDto convert(Employee from) {
        return new EmployeeDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getEmail(),
                from.getPhone()
        );
    }
}
