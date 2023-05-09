package com.klymovych.university.controllers;

import com.klymovych.university.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class SheduleController {

    private final StudentService studentService;


    private final ProfessorService professorService;


    private final CourseService courseService;

    private final GroupService groupService;


    private final LessonService lessonService;

    @GetMapping("/")
    public String showWelcomePage() {
        return "welcome";
    }

    @GetMapping("/student")
    public String showStudentPage(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping("/professor")
    public String showProfessorPage(Model model) {
        model.addAttribute("professors", professorService.findAll());
        return "professors";
    }

    @GetMapping("/course")
    public String showCoursePage(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courses";
    }

    @GetMapping("/group")
    public String showGroupPage(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "groups";
    }

    @GetMapping("/lesson")
    public String showLessonPage(Model model) {
        model.addAttribute("lessons", lessonService.findAll());
        return "lessons";
    }

}
