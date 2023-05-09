package com.klymovych.university.repositories;

import com.klymovych.university.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@DataJpaTest
@ContextConfiguration(classes = RepositoryTestConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"/sql/schemaTest.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class LessonRepositoryTest {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindLessonsByGroupIdAndDate() {
        Group group = Group.builder()
                .name("Group A")
                .status(Status.ACTIVE)
                .build();
        group = entityManager.persist(group);

        Course course = Course.builder()
                .name("Course A")
                .build();
        course = entityManager.persist(course);

        Professor professor = new Professor();
        professor.setFullName("John Doe");
        professor.setEmail("john.doe@example.com");
        professor.setCourses(List.of(course));
        professor.setStatus(Status.ACTIVE);
        Professor professorInDb = entityManager.persist(professor);

        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime finishTime = LocalTime.of(11, 0);
        LocalDate date = LocalDate.of(2023, 4, 15);
        LocalDate dateFinish = LocalDate.of(2023, 4, 17);

        Lesson lesson = Lesson.builder()
                .course(course)
                .professor(professorInDb)
                .startTime(startTime)
                .finishTime(finishTime)
                .group(group)
                .date(date)
                .build();
        entityManager.persist(lesson);

        List<Lesson> lessons = lessonRepository.findLessonsByGroupIdAndDate(
                group, date, dateFinish);
        Assertions.assertThat(lessons).hasSize(1);
        Assertions.assertThat(lessons.get(0)).isEqualTo(lesson);
    }

    @Test
    public void testFindLessonsByProfessorIdAndDate() {
        Group group = Group.builder()
                .name("Group A")
                .status(Status.ACTIVE)
                .build();
        group = entityManager.persist(group);

        Course course = Course.builder()
                .name("Course A")
                .build();
        course = entityManager.persist(course);

        Professor professor = new Professor();
        professor.setFullName("John Doe");
        professor.setEmail("john.doe@example.com");
        professor.setCourses(Collections.singletonList(course));
        professor.setStatus(Status.ACTIVE);
        professor = entityManager.persist(professor);

        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime finishTime = LocalTime.of(11, 0);
        LocalDate date = LocalDate.of(2023, 4, 15);
        LocalDate dateFinish = LocalDate.of(2023, 4, 17);

        Lesson lesson = Lesson.builder()
                .course(course)
                .professor(professor)
                .startTime(startTime)
                .finishTime(finishTime)
                .group(group)
                .date(date)
                .build();
        entityManager.persist(lesson);

        List<Lesson> lessons = lessonRepository.findLessonsByProfessorIdAndDate(
                professor, date, dateFinish);
        Assertions.assertThat(lessons).hasSize(1);
        Assertions.assertThat(lessons.get(0)).isEqualTo(lesson);
    }
}