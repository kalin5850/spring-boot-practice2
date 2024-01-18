package com.pykaicode.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pykaicode.cruddemo.dao.StudentDAO;
import com.pykaicode.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> createStudent(studentDAO);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating a new student object....");
		Student tempStudent = new Student("KaiLin",
				"Chang", "daokai0509@gmail.com");
		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.err.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
