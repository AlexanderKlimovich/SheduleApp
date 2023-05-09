package com.klymovych.university.services;

import com.klymovych.university.model.Group;
import com.klymovych.university.model.Student;

public interface StudentService extends Service<Student>{
    Group getGroupByStudentId(int id);
}
