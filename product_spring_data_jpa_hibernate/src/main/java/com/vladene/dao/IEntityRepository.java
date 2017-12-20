/**
 * 
 */
package com.vladene.dao;

import java.util.List;


/**
 * @author henri.tala
 *
 */
public interface IEntityRepository <T> {
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public T save (T p);

	/**
	 * 
	 * @return
	 */
	public List<T> findAll();
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T findOne(Long id);

	/**
	 * 
	 * @param kw
	 * @return
	 */
	public List<T> findByDesignation(String kw);
	
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public T update(T p);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);
	
	

}
