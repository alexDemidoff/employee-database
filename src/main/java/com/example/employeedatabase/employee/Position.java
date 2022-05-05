package com.example.employeedatabase.employee;

import javax.persistence.*;

@Entity
@Table
public class Position {
    @Id
    @SequenceGenerator(
            name = "position_sequence",
            sequenceName = "position_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "position_sequence"
    )
    private Long id;
    private String positionName;
    private Integer salary;

    public Position() {
    }

    public Position(Long id, String positionName, Integer salary) {
        this.id = id;
        this.positionName = positionName;
        this.salary = salary;
    }

    public Position(String positionName, Integer salary) {
        this.positionName = positionName;
        this.salary = salary;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionName='" + positionName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
