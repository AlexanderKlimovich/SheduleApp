package com.klymovych.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student")
public class Student extends Person{

    @ManyToOne
    @JoinColumn(name="group_id", referencedColumnName = "id")
    private Group group;
}
