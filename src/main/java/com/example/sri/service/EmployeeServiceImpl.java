package com.example.sri.service;






import com.example.sri.dto.EmployeeDto;
import com.example.sri.entity.Employee;
import com.example.sri.exception.ResourceNotFoundException;
import com.example.sri.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl
        implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public Employee createEmployee(EmployeeDto dto) {

        Employee employee = Employee.builder()
                .name(dto.getName())
                .email(dto.getEmail())

                .salary(dto.getSalary())
                .build();

        return repository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id,
                                   EmployeeDto dto) {

        Employee employee = getEmployee(id);

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());

        employee.setSalary(dto.getSalary());

        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = getEmployee(id);

        repository.delete(employee);
    }
}