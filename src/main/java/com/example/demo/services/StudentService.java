package com.example.demo.services;

import com.example.demo.models.Student;

import java.util.ArrayList;

public interface StudentService {
    ArrayList<Student> fetchAllStudents();
}
