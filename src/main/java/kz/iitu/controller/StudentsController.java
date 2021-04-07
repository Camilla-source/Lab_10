package kz.iitu.controller;

import kz.iitu.DAO.StudentsDAO;
import kz.iitu.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentsController {

    private StudentsDAO studentsDAO;

    @Autowired
    public StudentsController(StudentsDAO studentsDAO){
        this.studentsDAO = studentsDAO;
    }

    @GetMapping("")
    public String get(Model model){
        model.addAttribute("students", studentsDAO.list());
        return "page1";
    }

    @GetMapping("/{id}")
    public String search(@PathVariable("id") int id, Model model){
        model.addAttribute("student",studentsDAO.search(id));
        return "page2";
    }

    @GetMapping("/create")
    public String newStudent(Model model){
        model.addAttribute("student",new Student());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") Student student){
        studentsDAO.add(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String editStudent(@PathVariable("id") int id,Model model){
        model.addAttribute("student", studentsDAO.search(id));
        return "Edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") Student student, @PathVariable("id") int id) {
        studentsDAO.update(id,student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        studentsDAO.delete(id);
        return "redirect:/students";
    }

}
