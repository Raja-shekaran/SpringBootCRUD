package com.raja.cruddemo;

import com.raja.cruddemo.dao.StudentDAO;
import com.raja.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
//			createStudent(studentDAO);
//
			createMultipleStudents(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteall(studentDAO);
		};
	}

	private void deleteall(StudentDAO studentDAO) {

		int numROwsDeleted=studentDAO.deleteall();
		System.out.println(numROwsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=5;

		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId=2;

		Student myStudent = studentDAO.findById(studentId);

		myStudent.setLastName("Kamal");

		studentDAO.update(myStudent);

		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> lists = studentDAO.findByLastName("Malik");

		for(Student temp : lists)
		{
			System.out.println(temp);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> list = studentDAO.findAll();

		for(Student temp : list)
		{
			System.out.println(temp);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student ");

		Student tempStudent = new Student("Prince", "Persia", "prince@gmail.com");

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("Saved Student of id " +tempStudent.getId());

		Student mystudent = studentDAO.findById(tempStudent.getId());

		System.out.println(mystudent);


	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating Multiple Student");

		Student tempStudent1 = new Student("Andavar", "kamal", "andavar@gmail.com");
		Student tempStudent2 = new Student("Thala", "pangu", "thala@gmail.com");
		Student tempStudent3 = new Student("Thalapathy", "kanni", "thalapathy@gmail.com");

		System.out.println("Saving Multiple Student");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved Student of id " +tempStudent1.getId());
		System.out.println("Saved Student of id " +tempStudent2.getId());
		System.out.println("Saved Student of id " +tempStudent3.getId());


	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student ");

		Student tempStudent = new Student("Raja", "Malik", "raja@gmail.com");

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		System.out.println("Saved Student of id " +tempStudent.getId());
	}
}
