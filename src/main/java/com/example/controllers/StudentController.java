package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.Student;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    // In-memory storage for students (in a real app, this would be a database)
    private List<Student> students = new ArrayList<>();

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/register";
    }

    @PostMapping("/register")
    public String registerStudent(@Valid @ModelAttribute("student") Student student,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "students/register";
        }

        students.add(student);
        return "redirect:/students/list";
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}