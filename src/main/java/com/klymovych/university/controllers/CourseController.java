package com.klymovych.university.controllers;

import com.klymovych.university.model.Course;
import com.klymovych.university.services.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "courses";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getCourseById(@PathVariable("id") int id, Model model) {
        model.addAttribute("course", courseService.findById(id));
        return "course";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createCourse(@ModelAttribute("course") @Validated Course course, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "courseForm";
        }
        courseService.save(course);
        return "redirect:/courses";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateCourse(@PathVariable("id") int id, @ModelAttribute("course")
                                    @Validated Course course, BindingResult result) {
        if (result.hasErrors()) {
            return "courseForm";
        }
        course.setId(id);
        courseService.update(course);
        return "redirect:/courses";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCourseById(@PathVariable("id") int id) {
        courseService.deleteById(id);
        return "redirect:/courses";
    }
}
