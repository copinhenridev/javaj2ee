/**
 * 
 */
package com.vladene.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladene.entities.Category;

/**
 * @author henri.tala
 *
 */
public interface ICategoryJPARepository extends JpaRepository<Category, Long>{

}
