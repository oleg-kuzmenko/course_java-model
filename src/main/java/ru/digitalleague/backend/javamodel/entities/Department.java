package ru.digitalleague.backend.javamodel.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="department")
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    private String name;
    private Integer code;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Class> classList;

}
