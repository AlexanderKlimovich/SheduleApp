package com.klymovych.university.services.implementsAll;

import com.klymovych.university.model.Group;
import com.klymovych.university.model.Student;
import com.klymovych.university.repositories.LessonRepository;
import com.klymovych.university.repositories.StudentRepository;
import com.klymovych.university.services.ServiceException;
import com.klymovych.university.services.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(@Valid Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) throws ServiceException {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Student not found with id: " + id));
    }

    @Override
    public void deleteById(int id) {
        if (!studentRepository.existsById(id)) {
            throw new ServiceException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Group getGroupByStudentId(int id){
        return findById(id).getGroup();
    }
}

