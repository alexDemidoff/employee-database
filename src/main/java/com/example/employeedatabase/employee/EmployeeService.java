package com.example.employeedatabase.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);

        if (!exists) {
            throw new IllegalStateException(
                    "Employee with id " + employeeId + " does not exists"
            );
        }

        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String s, String surname, String name, LocalDate dob, LocalDate hireDate, LocalDate fireDate, String position) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new IllegalStateException(
                        "Employee with id " + employeeId + " does not exists"));

        if (name != null && name.length() > 0
                && !Objects.equals(employee.getName(), name)) {
            employee.setName(name);
        }

        if (position != null && position.length() > 0
        && !Objects.equals(employee.getPosition(), position)) {
            employee.setPosition(position);
        }
    }
}
