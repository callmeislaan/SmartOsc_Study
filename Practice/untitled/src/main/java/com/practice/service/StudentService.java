package com.practice.service;

import com.practice.connection.Connect;
import com.practice.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public List<Student> getAll() {
        String sql = "select * from student";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement statement = Connect.getConnection().prepareStatement(sql)){
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Student student = new Student();
                student.setId(set.getInt("id"));
                student.setName(set.getString("name"));
                student.setDob(set.getDate("dob"));
                student.setClassId(set.getInt("class_id"));
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }
}
