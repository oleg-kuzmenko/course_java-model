package ru.digitalleague.backend.javamodel.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "class")
@Entity
public class Class {


    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    private String name;
    private Integer duration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(name = "department_id", updatable = false, insertable = false)
    private Integer departmentId;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "classList")
    private List<Student> studentList;
}
