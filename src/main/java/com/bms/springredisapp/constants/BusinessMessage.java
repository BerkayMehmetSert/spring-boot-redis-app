package com.bms.springredisapp.constants;

public class BusinessMessage {
    private BusinessMessage() {
        throw new IllegalStateException("Utility class");
    }

    public static final String EMPLOYEE_ALREADY_EXISTS = "Employee already exists";
    public static final String EMPLOYEE_LIST_IS_EMPTY = "Employee list is empty";
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found";
}
