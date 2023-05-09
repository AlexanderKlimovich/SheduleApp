package com.klymovych.university.controllers;

import com.klymovych.university.model.Course;
import com.klymovych.university.model.Professor;
import com.klymovych.university.services.ProfessorService;
import com.klymovych.university.services.SheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    private final SheduleService sheduleService;

    @GetMapping
    public String getAllProfessors(Model model) {
        List<Professor> professors = professorService.findAll();
        model.addAttribute("professors", professors);
        return "professors";
    }

    @GetMapping("/{id}")
    public String getProfessorById(@PathVariable("id") int id, Model model) {
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);
        return "professor-details";
    }

    @GetMapping("/add")
    public String addProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor-form";
    }

    @PostMapping("/save")
    public String saveProfessor(@ModelAttribute("professor") @Validated Professor professor,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "professor-form";
        } else {
            professorService.save(professor);
            return "redirect:/professors";
        }
    }

    @GetMapping("/{id}/edit")
    public String editProfessor(@PathVariable("id") int id, Model model) {
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);
        return "professor-form";
    }

    @PostMapping("/{id}/update")
    public String updateProfessor(@PathVariable("id") int id,
                                  @ModelAttribute("professor") @Validated Professor professor,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "professor-form";
        } else {
            professor.setId(id);
            professorService.save(professor);
            return "redirect:/professors";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteProfessor(@PathVariable("id") int id) {
        professorService.deleteById(id);
        return "redirect:/professors";
    }

    @GetMapping("/{id}/courses")
    public String getCoursesByProfessorId(@PathVariable("id") int id, Model model) {
        List<Course> courses = professorService.getCoursesByProfessorId(id);
        model.addAttribute("courses", courses);
        return "courses-list";
    }
}
