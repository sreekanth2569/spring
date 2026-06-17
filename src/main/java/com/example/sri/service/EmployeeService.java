package com.example.sri.service;









import com.example.sri.dto.EmployeeDto;

import com.example.sri.entity.Employee;
import java.util.List;

public interface EmployeeService {

    Employee createEmployee(EmployeeDto dto);

    Employee getEmployee(Long id);

    List<Employee> getAllEmployees();


    Employee updateEmployee(Long id,
                            EmployeeDto dto);

    void deleteEmployee(Long id);
}