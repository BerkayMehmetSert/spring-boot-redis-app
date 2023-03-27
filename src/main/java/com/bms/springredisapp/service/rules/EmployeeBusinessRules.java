package com.bms.springredisapp.service.rules;

import com.bms.springredisapp.core.exceptions.BusinessException;
import com.bms.springredisapp.core.exceptions.NotFoundException;
import com.bms.springredisapp.model.Employee;
import com.bms.springredisapp.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.bms.springredisapp.constants.BusinessMessage.*;

@Component
public class EmployeeBusinessRules {
    private final EmployeeRepository employeeRepository;

    public EmployeeBusinessRules(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void checkIfEmployeeExistsByFirstName(final String firstName) {
        if (employeeRepository.existsByFirstNameIgnoreCase(firstName)) {
            throw new BusinessException(EMPLOYEE_ALREADY_EXISTS);
        }
    }

    public void checkIfEmployeeListIsEmpty(final List<Employee> employees) {
        if (employees.isEmpty()) {
            throw new NotFoundException(EMPLOYEE_LIST_IS_EMPTY);
        }
    }

    public Employee checkIfEmployeeExistsByIdReturnEmployee(final Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));
    }

    public Employee checkIfEmployeeExistsByFirstNameReturnEmployee(final String firstName) {
        return employeeRepository.findByFirstNameIgnoreCase(firstName)
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));
    }
}
