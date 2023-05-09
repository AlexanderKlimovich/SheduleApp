package com.klymovych.university.services;

import com.klymovych.university.model.Course;
import com.klymovych.university.model.Professor;

import java.util.List;

public interface ProfessorService extends Service<Professor> {
    List<Course> getCoursesByProfessorId(int id);
}
