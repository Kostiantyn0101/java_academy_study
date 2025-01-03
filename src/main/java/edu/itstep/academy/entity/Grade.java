package edu.itstep.academy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "grades")
@Data
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Min(value = 0, message = "Min 0")
    @Max(value = 100, message = "Max 100")
    @Column(name = "grade")
    private int grade;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    @NotNull(message = "Date is empty!")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

}
