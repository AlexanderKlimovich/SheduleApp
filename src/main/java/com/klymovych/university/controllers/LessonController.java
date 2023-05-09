package com.klymovych.university.controllers;

import com.klymovych.university.model.Lesson;
import com.klymovych.university.services.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public String getAllLessons(Model model) {
        model.addAttribute("lessons", lessonService.findAll());
        return "lessons";
    }

    @GetMapping("/{id}")
    public String getLessonById(@PathVariable("id") int id, Model model) {
        model.addAttribute("lesson", lessonService.findById(id));
        return "lesson";
    }

    @PostMapping
    public String createLesson(@ModelAttribute("lesson") @Validated Lesson lesson, BindingResult result) {
        if (result.hasErrors()) {
            return "lesson-form";
        }
        lessonService.save(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/new")
    public String showLessonForm(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "lesson-form";
    }

    @GetMapping("/{id}/edit")
    public String showLessonEditForm(@PathVariable("id") int id, Model model) {
        Lesson lesson = lessonService.findById(id);
        model.addAttribute("lesson", lessonService.findById(id));
        return "lesson-form";
    }

    @PostMapping("/{id}")
    public String updateLesson(@PathVariable("id") int id, @ModelAttribute("lesson") @Validated Lesson lesson, BindingResult result) {
        if (result.hasErrors()) {
            return "lesson-form";
        }
        lesson.setId(id);
        lessonService.update(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/{id}/delete")
    public String deleteLessonById(@PathVariable("id") int id) {
        lessonService.deleteById(id);
        return "redirect:/lessons";
    }
}