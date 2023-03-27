package com.bms.springredisapp.controller;

import com.bms.springredisapp.dto.EmployeeDto;
import com.bms.springredisapp.request.CreateEmployeeRequest;
import com.bms.springredisapp.request.UpdateEmployeeRequest;
import com.bms.springredisapp.response.EmployeeResponse;
import com.bms.springredisapp.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createEmployee(@RequestBody CreateEmployeeRequest request) {
        service.createEmployee(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request) {
        service.updateEmployee(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @GetMapping("/name/{firstName}")
    public ResponseEntity<EmployeeDto> getEmployeeByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(service.getEmployeeByFirstName(firstName));
    }

    @GetMapping("/all")
    public ResponseEntity<EmployeeResponse> getAllEmployees(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(service.getAllEmployees(page, size));
    }
}
