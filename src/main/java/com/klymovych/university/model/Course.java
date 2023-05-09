package com.klymovych.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Course name cannot be null")
    @NotBlank(message = "Course name cannot be blank")
    @Size(min = 2, max = 255, message = "Course name must be between 2 and 255 characters")
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Professor> professors;
}
