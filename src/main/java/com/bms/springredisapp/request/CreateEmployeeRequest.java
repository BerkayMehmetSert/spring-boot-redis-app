package com.bms.springredisapp.request;

public record CreateEmployeeRequest(
        String firstName,
        String lastName,
        String email,
        String phone
) {
}
