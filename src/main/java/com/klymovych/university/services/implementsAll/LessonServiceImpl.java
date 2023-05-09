package com.klymovych.university.services.implementsAll;

import com.klymovych.university.model.Group;
import com.klymovych.university.model.Lesson;
import com.klymovych.university.repositories.LessonRepository;
import com.klymovych.university.services.LessonService;
import com.klymovych.university.services.ServiceException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;
    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Lesson save(@Valid Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findById(int id) {
        return lessonRepository.findById(id).
                orElseThrow(() -> new ServiceException("Lesson not found with id: " + id));
    }

    @Override
    public void deleteById(int id) {
        if (!lessonRepository.existsById(id)) {
            throw new ServiceException("Lesson not found with id: " + id);
        }
        lessonRepository.deleteById(id);
    }

    @Override
    public Lesson update(@Valid Lesson lesson){
        Lesson existingLesson = lessonRepository.findById(lesson.getId())
                .orElseThrow(() -> new ServiceException("Lesson not found with id: " + lesson.getId()));
        existingLesson.setCourse(lesson.getCourse());
        existingLesson.setGroup(lesson.getGroup());
        existingLesson.setProfessor(lesson.getProfessor());
        existingLesson.setStartTime(lesson.getStartTime());
        existingLesson.setFinishTime(lesson.getFinishTime());
        existingLesson.setDate(lesson.getDate());
        return lessonRepository.save(existingLesson);
    }
}
