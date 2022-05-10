package com.example.employeedatabase.position;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
