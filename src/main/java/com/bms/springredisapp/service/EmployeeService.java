package com.bms.springredisapp.service;

import com.bms.springredisapp.dto.EmployeeDto;
import com.bms.springredisapp.model.Employee;
import com.bms.springredisapp.repository.EmployeeRepository;
import com.bms.springredisapp.request.CreateEmployeeRequest;
import com.bms.springredisapp.request.UpdateEmployeeRequest;
import com.bms.springredisapp.response.EmployeeResponse;
import com.bms.springredisapp.service.rules.EmployeeBusinessRules;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeBusinessRules rules;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeBusinessRules rules) {
        this.employeeRepository = employeeRepository;
        this.rules = rules;
    }

    @CachePut(value = "employees", key = "#request.firstName()")
    public void createEmployee(final CreateEmployeeRequest request) {
        rules.checkIfEmployeeExistsByFirstName(request.firstName());

        Employee employee = new Employee(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.phone()
        );

        employeeRepository.save(employee);
    }

    @CachePut(value = "employees", key = "#request.firstName() + #request.lastName()")
    public void updateEmployee(final Long id, final UpdateEmployeeRequest request) {
        Employee employee = getEmployee(id);

        Employee updatedEmployee = new Employee(
                employee.getId(),
                request.firstName(),
                request.lastName(),
                request.email(),
                request.phone()
        );

        employeeRepository.save(updatedEmployee);
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(final Long id) {
        employeeRepository.delete(getEmployee(id));
    }

    @Cacheable(value = "employees", key = "#id")
    public EmployeeDto getEmployeeById(final Long id) {
        Employee employee = getEmployee(id);

        return EmployeeDto.convert(employee);
    }

    @Cacheable(value = "employees", key = "#firstName")
    public EmployeeDto getEmployeeByFirstName(final String firstName) {
        Employee employee = rules.checkIfEmployeeExistsByFirstNameReturnEmployee(firstName);

        return EmployeeDto.convert(employee);
    }

    @Cacheable(value = "employees", key = "#root.methodName")
    public EmployeeResponse getAllEmployees(final Integer page, final Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employees = employeeRepository.findAll(pageable);

        rules.checkIfEmployeeListIsEmpty(employees.getContent());

        return new EmployeeResponse(
                employees.getNumber(),
                employees.getSize(),
                employees.getTotalPages(),
                employees.getTotalElements(),
                employees.hasNext(),
                employees.hasPrevious(),
                employees.getContent().stream().map(EmployeeDto::convert).toList()
        );
    }

    private Employee getEmployee(final Long id) {
        return rules.checkIfEmployeeExistsByIdReturnEmployee(id);
    }
}
