package com.pykaicode.cruddemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.pykaicode.cruddemo.dao.StudentDAO;
import com.pykaicode.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(10, studentDAO);
			// getAllStudents(studentDAO);
			getStudentByLastName(studentDAO, "Chang");
		};
	}

	private void getStudentByLastName(StudentDAO studentDAO, String lastName) {
		List<Student> students = studentDAO.findByLastName(lastName);
		System.out.println(students);
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(Integer id, StudentDAO studentDAO) {
		Student student = studentDAO.findById(id);
		System.out.println("Found the student: " + student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Faker faker = new Faker();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Student tmpStudent = new Student(
					faker.name().firstName(),
					faker.name().lastName(),
					faker.internet().emailAddress());
			students.add(tmpStudent);
			studentDAO.save(tmpStudent);
		}
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
