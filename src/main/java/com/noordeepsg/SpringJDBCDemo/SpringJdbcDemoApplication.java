package com.noordeepsg.SpringJDBCDemo;

import com.noordeepsg.SpringJDBCDemo.Model.Student;
import com.noordeepsg.SpringJDBCDemo.Repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);
		Student student = context.getBean(Student.class);
		student.setName("Noordeep");
		student.setAddress("14 Shepherd Ave");
		student.setRollnumber(104);

		StudentRepository repo = context.getBean(StudentRepository.class);
		repo.save(student);

		System.out.println(repo.findAll());
	}

}
