package org.example.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("Id"));
        student.setLastName(rs.getString("LastName"));
        student.setFirstName(rs.getString("FirstName"));
        student.setAddress(rs.getString("Address"));
        student.setCity(rs.getString("City"));
        return student;
    }
}