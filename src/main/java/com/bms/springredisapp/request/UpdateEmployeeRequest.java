package com.bms.springredisapp.request;

public record UpdateEmployeeRequest(
        String firstName,
        String lastName,
        String email,
        String phone
) {
}
