package com.klymovych.university.controllers;

import com.klymovych.university.model.Group;
import com.klymovych.university.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public String getAllGroups(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "groups";
    }

    @GetMapping("/{id}")
    public String getGroupById(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupService.findById(id));
        return "group-details";
    }

    @PostMapping
    public String createGroup(@ModelAttribute("group") @Validated Group group, BindingResult result) {
        if (result.hasErrors()) {
            return "group-form";
        } else {
            groupService.save(group);
            return "redirect:/groups";
        }
    }

    @GetMapping("/new")
    public String showGroupForm(Model model) {
        model.addAttribute("group", new Group());
        return "group-form";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupService.findById(id));
        return "group-form";
    }

    @PostMapping("/{id}/edit")
    public String editGroup(@ModelAttribute("group") @Validated Group group, BindingResult result) {
        if (result.hasErrors()) {
            return "group-form";
        } else {
            groupService.update(group);
            return "redirect:/groups";
        }
    }

    @GetMapping("/{id}/delete")
    public String showDeleteForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupService.findById(id));
        return "group-delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteGroup(@PathVariable("id") int id) {
        groupService.deleteById(id);
        return "redirect:/groups";
    }
}







