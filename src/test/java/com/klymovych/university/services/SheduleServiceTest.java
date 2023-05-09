package com.klymovych.university.services;

import com.klymovych.university.model.*;
import com.klymovych.university.repositories.LessonRepository;
import com.klymovych.university.services.implementsAll.SheduleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SheduleServiceImpl.class})
public class SheduleServiceTest {

    @MockBean
    private LessonRepository lessonRepository;

    @Autowired
    private SheduleService sheduleService;

    @Test
    public void testGetStudentShedule() {
        Student student = new Student();
        Group group = new Group();
        group.setId(1);
        student.setGroup(group);
        Lesson lesson1 = Lesson.builder()
                .id(1)
                .course(new Course())
                .professor(new Professor())
                .startTime(LocalTime.of(9, 0))
                .finishTime(LocalTime.of(11, 0))
                .group(group)
                .date(LocalDate.of(2023, 4, 15))
                .build();
        Lesson lesson2 = Lesson.builder()
                .id(2)
                .course(new Course())
                .professor(new Professor())
                .startTime(LocalTime.of(13, 0))
                .finishTime(LocalTime.of(15, 0))
                .group(group)
                .date(LocalDate.of(2023, 4, 16))
                .build();
        List<Lesson> lessons = Arrays.asList(lesson1, lesson2);

        when(lessonRepository.findLessonsByGroupIdAndDate(any(Group.class), any(LocalDate.class), any(LocalDate.class)))
                .thenReturn(lessons);

        List<Lesson> result = sheduleService.getStudentShedule(student, Term.WEEK);

        assertEquals(2, result.size());
        assertEquals(lesson1, result.get(0));
        assertEquals(lesson2, result.get(1));
    }

    @Test
    public void testGetProfessorShedule() {
        Professor professor = new Professor();
        Lesson lesson1 = Lesson.builder()
                .id(1)
                .course(new Course())
                .professor(professor)
                .startTime(LocalTime.of(9, 0))
                .finishTime(LocalTime.of(11, 0))
                .group(new Group())
                .date(LocalDate.of(2023, 4, 17))
                .build();
        Lesson lesson2 = Lesson.builder()
                .id(2)
                .course(new Course())
                .professor(professor)
                .startTime(LocalTime.of(13, 0))
                .finishTime(LocalTime.of(15, 0))
                .group(new Group())
                .date(LocalDate.of(2023, 4, 18))
                .build();
        List<Lesson> lessons = Arrays.asList(lesson1, lesson2);

        when(lessonRepository.findLessonsByProfessorIdAndDate(any(Professor.class),
                any(LocalDate.class), any(LocalDate.class))).thenReturn(lessons);

        List<Lesson> result = sheduleService.getProfessorShedule(professor, Term.MONTH);

        assertEquals(2, result.size());
        assertEquals(lesson1, result.get(0));
        assertEquals(lesson2, result.get(1));
    }
}