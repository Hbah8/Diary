package com.utitlities.application.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void postStudent(@RequestBody Student student) {

        studentService.addNewStudent(student);
    }
    @PutMapping(path = "{studentId}")
    public void postStudent(@PathVariable("studentId") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        studentService.updateStudent(id, name, email);
    }
    @DeleteMapping(path = "{studentId}")
    public void postStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }
}
