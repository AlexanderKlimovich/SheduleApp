package com.klymovych.university.services;

import com.klymovych.university.model.Lesson;
import com.klymovych.university.model.Professor;
import com.klymovych.university.model.Student;

import javax.validation.Valid;
import java.util.List;

public interface SheduleService {
    List<Lesson> getStudentShedule(Student student, Term term);

    List<Lesson> getProfessorShedule(Professor professor, Term term);
}
