package com.bms.springredisapp.repository;

import com.bms.springredisapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByFirstNameIgnoreCase(String firstName);

    Optional<Employee> findByFirstNameIgnoreCase(String firstName);
}
