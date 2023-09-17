package com.ourcompany.ourcompanytable.data.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "COMPANY", name = "Employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String guid;

    private String name;

    @Nullable
    private Long bDate;

    public EmployeeEntity(String name, @Nullable Long bDate) {
        this.name = name;
        this.bDate = bDate;
    }
}
