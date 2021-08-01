package ru.digitalleague.backend.javamodel.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String firstName;
    private String lastName;

    @Size(min = 1, max = 1)
    private String gender;

    @Email(message = "Email should be valid")
    private String email;

    @Past
    private LocalDate dob;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="lnk_class_to_student", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "class_id", referencedColumnName = "class_id"))
    private List<Class> classList;

}
