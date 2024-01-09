package com.noordeepsg.SpringJDBCDemo.Repository;

import com.noordeepsg.SpringJDBCDemo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Student student){
        String sql = "insert into Student values (?,?,?)";
        int rows = template.update(sql, student.getName(), student.getRollnumber(), student.getAddress());
        System.out.println(rows + " rows affected");
    }

    public List<Student> findAll(){

        String sql = "Select * from Student";

        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setName(rs.getString(1));
                s.setRollnumber(rs.getInt(2));
                s.setAddress(rs.getString(3));
                return s;
            }
        };

        List<Student> list= template.query(sql, mapper);
        return list;
    }
}
