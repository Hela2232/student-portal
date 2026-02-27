package com.example.services;  // "services" avec 's'

import com.example.models.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    
    private List<Student> students = new ArrayList<>();
    
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }
    
    public void save(Student student) {
        students.add(student);
    }
}
