package edu.itstep.academy.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "role_names")
@Data
@NoArgsConstructor
public class RoleName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role", unique = true, nullable = false)
    private String name;
}
