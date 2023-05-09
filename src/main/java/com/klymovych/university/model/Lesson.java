package com.klymovych.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "lesson")
public class Lesson {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Course is mandatory")
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @NotNull(message = "Professor is mandatory")
    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id")
    private Professor professor;

    @NotNull(message = "Start time is mandatory")
    @Column(name = "start_time")
    private LocalTime startTime;

    @NotNull(message = "Finish time is mandatory")
    @Column(name = "finish_time")
    private LocalTime finishTime;

    @NotNull(message = "Group is mandatory")
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    @NotNull(message = "Date is mandatory")
    @Column(name = "date")
    private LocalDate date;
}
