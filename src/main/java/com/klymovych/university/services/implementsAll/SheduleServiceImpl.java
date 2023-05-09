package com.klymovych.university.services.implementsAll;

import com.klymovych.university.model.Lesson;
import com.klymovych.university.model.Professor;
import com.klymovych.university.model.Student;
import com.klymovych.university.repositories.LessonRepository;
import com.klymovych.university.services.SheduleService;
import com.klymovych.university.services.Term;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class SheduleServiceImpl implements SheduleService {

    private LessonRepository lessonRepository;
    @Autowired
    public SheduleServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<Lesson> getStudentShedule(@Valid Student student, Term term){
        HashMap<String, LocalDate> dates = makeData(term);
        return lessonRepository.findLessonsByGroupIdAndDate(student.getGroup(),
                dates.get("start"), dates.get("finish"));
    }

    @Override
    public List<Lesson> getProfessorShedule(@Valid Professor professor, Term term){
        HashMap<String, LocalDate> dates = makeData(term);
        return lessonRepository.findLessonsByProfessorIdAndDate(professor,
                dates.get("start"), dates.get("finish"));
    }

    private HashMap<String, LocalDate> makeData(Term term){
        LocalDate startDate = LocalDate.now();
        LocalDate finishDate = term.addToDate(startDate);
        HashMap<String, LocalDate> dates = new HashMap<>();
        dates.put("start",startDate);
        dates.put("finish",finishDate);
        return dates;
    }

}
