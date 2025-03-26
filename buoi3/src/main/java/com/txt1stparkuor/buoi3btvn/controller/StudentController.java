package com.txt1stparkuor.buoi3btvn.controller;

import com.txt1stparkuor.buoi3btvn.entity.Student;
import com.txt1stparkuor.buoi3btvn.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        studentService.updateStudent(id,student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
