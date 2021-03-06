package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("students", studentService.fetchAllStudents());

        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.fetchAllStudents());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student, Model model){
        String index = Integer.toString(studentService.fetchAllStudents().size());
        student.setStudentId(Integer.parseInt(index));
        studentService.fetchAllStudents().add(student);
        model.addAttribute("students", studentService.fetchAllStudents());
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") int id, Model model){
        model.addAttribute("student", studentService.fetchAllStudents().get(id));
        return "/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("student", studentService.fetchAllStudents().get(id));
        model.addAttribute("students", studentService.fetchAllStudents());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Student student, Model model){
        int id = student.getStudentId();
        for(int i = 0; i < studentService.fetchAllStudents().size(); i++){
            if(student.getStudentId() == studentService.fetchAllStudents().get(i).getStudentId()){
                studentService.fetchAllStudents().set(i, student);
                break;
            }
        }
        model.addAttribute("students", studentService.fetchAllStudents());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){
        model.addAttribute("student", studentService.fetchAllStudents().get(id));
        model.addAttribute("students", studentService.fetchAllStudents());
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Student student, Model model){
        int id = student.getStudentId();
        studentService.fetchAllStudents().remove(student.getStudentId());
        studentService.leftShiftId(id);
        model.addAttribute("students", studentService.fetchAllStudents());
        return "redirect:/";
    }

}
