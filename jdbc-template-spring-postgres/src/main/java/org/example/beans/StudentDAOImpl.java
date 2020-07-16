package org.example.beans;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAOImpl implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(int id, String lastName, String firstName, String address, String city) {
        String insertQuery = "INSERT INTO Students (Id, LastName, FirstName, Address, City) values (?, ?,?,?,?)";
        jdbcTemplateObject.update( insertQuery, id, lastName,firstName,address,city);
        System.out.println("Created Record for " + firstName);
        return;
    }
    public List<Student> listStudents() {
        String SQL = "select * from Students";
        List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }
}