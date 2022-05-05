package com.example.employeedatabase.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new IllegalStateException(
                        "Employee with id " + employeeId + " does not exists"
                )
        );
    }

    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
