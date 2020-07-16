package org.example;

import org.example.beans.Student;
import org.example.beans.StudentDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws  ClassNotFoundException, SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        StudentDAOImpl studentDAO =
                (StudentDAOImpl)context.getBean("studentJDBCTemplate");

        System.out.println("------Records Creation--------" );
        studentDAO.create(1, "kl","mk","pune","baner" );

        System.out.println("------Listing Multiple Records--------" );
        List<Student> students = studentDAO.listStudents();

        for (Student record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", address : " + record.getAddress() );
            System.out.println(", firstname : " + record.getFirstName());
            System.out.println(", lastname : " + record.getLastName());
            System.out.println(", city : " + record.getCity());
        }
    }
}
