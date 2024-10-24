package edu.itstep.academy.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
public class Teacher {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

}
