package com.example.demo.services;

import com.example.demo.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jeppe on 20-02-2018.
 */

@Service
public class StudentServiceImpl implements StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public StudentServiceImpl() {
        students.add(new Student(1, "Jeppe", "Henmar", "1234123457", new Date()));
        students.add(new Student(2, "Hans", "Henriksen", "1234123453", new Date()));
        students.add(new Student(3, "Ulrik", "Testmann", "1234123451", new Date()));
        students.add(new Student(4, "Marianne", "Jensen", "1234123452", new Date()));
        students.add(new Student(5, "Sofie", "Sørensen", "1234123454", new Date()));
        students.add(new Student(6, "Jens", "Løvendahl", "1234123459", new Date()));
    }

    @Override
    public ArrayList<Student> fetchAllStudents() {
        return students;
    }
}
