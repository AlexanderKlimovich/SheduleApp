package com.klymovych.university.services.implementsAll;

import com.klymovych.university.model.Course;
import com.klymovych.university.model.Group;
import com.klymovych.university.model.Professor;
import com.klymovych.university.repositories.LessonRepository;
import com.klymovych.university.repositories.ProfessorRepository;
import com.klymovych.university.services.ProfessorService;
import com.klymovych.university.services.ServiceException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;
    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Professor save(@Valid Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor update(Professor professor) throws ServiceException {
        Professor existingProfessor = professorRepository.findById(professor.getId())
                .orElseThrow(() -> new ServiceException("Group not found with id: " + professor.getId()));
        existingProfessor.setFullName(professor.getFullName());
        existingProfessor.setEmail(professor.getEmail());
        existingProfessor.setCourses(professor.getCourses());
        existingProfessor.setStatus(professor.getStatus());
        return professorRepository.save(existingProfessor);
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor findById(int id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Professor not found with id: " + id));
    }

    @Override
    public void deleteById(int id) {
        if (!professorRepository.existsById(id)) {
            throw new ServiceException("Professor not found with id: " + id);
        }
        professorRepository.deleteById(id);
    }

    @Override
    public List<Course> getCoursesByProfessorId(int id){
        if (!professorRepository.existsById(id)) {
            throw new ServiceException("Professor not found with id: " + id);
        }
        return findById(id).getCourses();
    }
}
