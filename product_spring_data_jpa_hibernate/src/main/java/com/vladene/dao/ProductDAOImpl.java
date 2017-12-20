/**
 * 
 */
package com.vladene.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vladene.entities.Product;

/**
 * @author henri.tala
 *
 */

@Repository
@Transactional
public class ProductDAOImpl implements IEntityRepository<Product> {

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.vladene.dao.IEntityRepository#save(java.lang.Object)
	 */
	@Override
	public Product save(Product p) {
		 em.persist(p);
		 return p;
	}

	/* (non-Javadoc)
	 * @see com.vladene.dao.IEntityRepository#findAll()
	 */
	@Override
	public List<Product> findAll() {
		Query req = em.createQuery("select p from Product p");
		return req.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see com.vladene.dao.IEntityRepository#findByDesignation(java.lang.String)
	 */
	@Override
	public List<Product> findByDesignation(String kw) {
		Query req = em.createQuery("select p from Product p where p.designation like :x");
		req.setParameter("x", kw);
		return req.getResultList();
	}


	/* (non-Javadoc)
	 * @see com.vladene.dao.IEntityRepository#findOne(java.lang.Long)
	 */
	@Override
	public Product findOne(Long id) {
		Product p = em.find(Product.class, id);
		
		return p;
	}


	/* (non-Javadoc)
	 * @see com.vladene.dao.IEntityRepository#update(java.lang.Object)
	 */
	@Override
	public Product update(Product p) {
		 return em.merge(p);
	}

	/* (non-Javadoc)
	 * @see com.vladene.dao.IEntityRepository#delete(java.lang.Long)
	 */
	@Override
	public boolean delete(Long id) {

		em.remove(findOne(id));
		
		return true;
	}

}
