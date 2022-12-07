package ru.geekbrains.api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

public class StudentController {
    private final List<Student> students = List.of(
            new Student(1L, "Student #1"),
            new Student(2L, "Student #2"),
            new Student(3L, "Student #3"),
            new Student(4L, "Student #4"),
            new Student(5L, "Student #5")
    );

    @GetMapping("/{id}")
    @ResponseBody
    public String getStudent(@PathVariable Long id) {
        Student student = students.stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst()
                .orElse(null);
        return student.getName();
    }

    @GetMapping
    public String getStudents (Model model) {
        model.addAttribute("studentList", students);
        return "students";

    }
}
