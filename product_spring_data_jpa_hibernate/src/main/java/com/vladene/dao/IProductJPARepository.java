/**
 * 
 */
package com.vladene.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vladene.entities.Product;

/**
 * @author henri.tala
 *
 */
public interface IProductJPARepository extends JpaRepository<Product, Long> {

	
	@Query("select p from Product p where p.designation like :x")
	public List<Product> productsByKeyWord(@Param("x")String kw);
	
}
