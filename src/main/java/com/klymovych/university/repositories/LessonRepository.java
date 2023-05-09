package com.klymovych.university.repositories;

import com.klymovych.university.model.Group;
import com.klymovych.university.model.Lesson;
import com.klymovych.university.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @Query("FROM Lesson l WHERE l.group = :groupId AND l.date BETWEEN :startDate AND :endDate")
    List<Lesson> findLessonsByGroupIdAndDate(@Param("groupId") Group group,
                                             @Param("startDate") LocalDate startDate,
                                             @Param("endDate") LocalDate endDate);

    @Query("FROM Lesson l WHERE l.professor = :professorId AND l.date BETWEEN :startDate AND :endDate")
    List<Lesson> findLessonsByProfessorIdAndDate(@Param("professorId")Professor professor,
                                                 @Param("startDate") LocalDate startDate,
                                                 @Param("endDate") LocalDate endDate);
}
