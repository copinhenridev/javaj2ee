/**
 * 
 */
package com.vladene.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vladene.student.dao.StudentRepository;
import com.vladene.student.entities.Student;

/**
 * @author Vladene
 *
 */
@Controller
@RequestMapping(value = "/Students")
public class StudentController  {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value="/Index")
	public String index(Model model , @RequestParam(name ="p_kW" , defaultValue ="") String p_kW  , @RequestParam(name ="p_page" , defaultValue ="0")  int p_page) {
	
		//List<Student> listStudents = studentRepository.findAll();
		//Page<Student> listStudents = studentRepository.findAll(new PageRequest(p_page, 5));
		
		Page<Student> listStudents = studentRepository.findStudents("%"+p_kW+"%" , new PageRequest(p_page, 5));
		
		int numberOfPages = listStudents.getTotalPages();
		
		int[] pages = new int[numberOfPages];
		for(int i=0; i<pages.length; i++) {
			pages[i] = i;
		}
		
		model.addAttribute("p_kW", p_kW);
		model.addAttribute("pagePagination", pages);
		model.addAttribute("currentPage", p_page);
		model.addAttribute("listStudents", listStudents);
		
		return "students";
	}
	
	
	

}
