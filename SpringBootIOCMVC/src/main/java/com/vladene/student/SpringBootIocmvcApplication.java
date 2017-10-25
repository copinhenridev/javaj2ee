package com.vladene.student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.vladene.student.dao.StudentRepository;
import com.vladene.student.entities.Student;


@SpringBootApplication
public class SpringBootIocmvcApplication {

	
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootIocmvcApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);

		initData(studentRepository);
		
		find(studentRepository);
		


	}


	
	public static void find(StudentRepository studentRepository ) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//Page<Student>  resultStudendByName = studentRepository.findByName("Henri COPIN TALA", new PageRequest(0, 5));
		//resultStudendByName.forEach(e->System.out.println(e.getName()));

		//Page<Student>  resultStudendLikeName = studentRepository.findStudents("%a%", new PageRequest(0, 5));
		//resultStudendLikeName.forEach(e->System.out.println(e.getName()));
		
		Page<Student> resultStudentBetweenDate = null;

		try {
			resultStudentBetweenDate = studentRepository.findStudentsBetweenDate(dateFormat.parse("10/06/2016"), dateFormat.parse("10/06/2017"), 
					new PageRequest(0, 5));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		resultStudentBetweenDate.forEach(e->System.out.println(e.getName()));
	}
	
	public static void initData (StudentRepository studentRepository) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {

			studentRepository.save(new Student("Henri COPIN TALA", dateFormat.parse("10/07/1986"), "copin_henri@yahoo.fr", "henri.jpg"));
			studentRepository.save(new Student("David Vladimir KAMWA LIODOP", dateFormat.parse("03/01/2017"), "david.liodop@vladene.com", "david.jpg"));
			studentRepository.save(new Student("Larissa TCHOUAME", dateFormat.parse("11/08/1986"), "larissa.leodop@gmail.com", "larissa.jpg"));
			studentRepository.save(new Student("Edna de BAMENDA", dateFormat.parse("09/11/1993"), "edna@canada.com", "edna.jpg"));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
