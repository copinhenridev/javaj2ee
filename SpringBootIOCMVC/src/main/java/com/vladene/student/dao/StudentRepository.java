/**
 * This class represent the access data layer for student entities
 */
package com.vladene.student.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vladene.student.entities.Student;

/**
 * @author Vladene
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	
	public Page<Student> findByName(String name, Pageable page);
	
	@Query("select s from Student s where s.name like :p_kW")
	public Page<Student> findStudents(@Param("p_kW") String kW, Pageable page);

	@Query("select s from Student s where s.birthDate >:p_d1 and s.birthDate <:p_d2")
	public Page<Student> findStudentsBetweenDate(@Param("p_d1") Date beginDate, @Param("p_d2") Date endDate , Pageable page);
	
	

}
