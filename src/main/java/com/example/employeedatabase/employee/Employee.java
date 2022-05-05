package com.example.employeedatabase.employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String surname;
    private String patronymicName;
    private LocalDate dob;
    private LocalDate hireDate;
    private LocalDate fireDate;
    private String occupation;

    public Employee() {
    }

    public Employee(String name, String surname, String patronymicName, LocalDate dob, LocalDate hireDate, LocalDate fireDate, String occupation) {
        this.name = name;
        this.surname = surname;
        this.patronymicName = patronymicName;
        this.dob = dob;
        this.hireDate = hireDate;
        this.fireDate = fireDate;
        this.occupation = occupation;
    }

    public Employee(Long id, String name, String surname, String patronymicName, LocalDate dob, LocalDate hireDate, LocalDate fireDate, String occupation) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymicName = patronymicName;
        this.dob = dob;
        this.hireDate = hireDate;
        this.fireDate = fireDate;
        this.occupation = occupation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getFireDate() {
        return fireDate;
    }

    public void setFireDate(LocalDate fireDate) {
        this.fireDate = fireDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", dob=" + dob +
                ", hireDate=" + hireDate +
                ", fireDate=" + fireDate +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
