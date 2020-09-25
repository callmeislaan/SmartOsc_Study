package com.practice.controller;

import com.practice.entity.Student;
import com.practice.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentController extends HttpServlet {

    public StudentController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentService();
        List<Student> students = studentService.getAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }

}
