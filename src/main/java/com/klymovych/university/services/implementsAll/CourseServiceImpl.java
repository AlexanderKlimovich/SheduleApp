package com.klymovych.university.services.implementsAll;

import com.klymovych.university.model.Course;
import com.klymovych.university.repositories.CourseRepository;
import com.klymovych.university.services.CourseService;
import com.klymovych.university.services.ServiceException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Course not found with id: " + id));
    }

    @Override
    public Course save(@Valid Course course) {
        return courseRepository.save(course);
    }
    @Override
    public Course update(@Valid Course course) {
        Course existingCourse = courseRepository.findById(course.getId())
                .orElseThrow(() -> new ServiceException("Course not found with id: " + course.getId()));
        existingCourse.setName(course.getName());
        existingCourse.setProfessors(course.getProfessors());
        return courseRepository.save(existingCourse);
    }
    @Override
    public void deleteById(int id) {
        if (!courseRepository.existsById(id)) {
            throw new ServiceException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }
}
