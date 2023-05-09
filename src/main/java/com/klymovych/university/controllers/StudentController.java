package com.klymovych.university.controllers;

import com.klymovych.university.model.Student;
import com.klymovych.university.services.SheduleService;
import com.klymovych.university.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    private final SheduleService sheduleService;

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/new")
    public String createStudent(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student-form";
        }
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String updateStudentForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student-form";
    }

    @PostMapping("/{id}/edit")
    public String updateStudent(@PathVariable("id") int id, @Validated @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student-form";
        }
        student.setId(id);
        studentService.save(student);
        return "redirect:students";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudentForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", studentService.findById(id));
        return "students-delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }

}