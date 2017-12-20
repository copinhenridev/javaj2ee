package com.vladene;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vladene.dao.ICategoryJPARepository;
import com.vladene.dao.IEntityRepository;
import com.vladene.dao.IProductJPARepository;
import com.vladene.entities.Category;
import com.vladene.entities.Product;

/**
 * @author henri.tala
 *
 */
@SpringBootApplication
public class ProductSpringDataJpaHibernateApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProductSpringDataJpaHibernateApplication.class, args);
		IEntityRepository<Product> productDao = ctx.getBean(IEntityRepository.class);

		/**
		 * simple test to add and read added products using Entitymanager from scratch
		 */
		productDao.save(new Product("LX456" , 8000, 7));
		productDao.save(new Product("HP 654" , 500, 8));
		productDao.save(new Product("HP 786" , 200, 5));
		
		List<Product> products  = productDao.findByDesignation("%H%");
		for(Product p: products) {
			System.out.println("Des: "+p.getDesignation());
			System.out.println("Price: "+p.getPrice());
		}
	
		/**
		 * Second case using spring data
		 */
		
		IProductJPARepository productDaoFromJpaSpring = ctx.getBean(IProductJPARepository.class);
		
		productDaoFromJpaSpring.save(new Product("SDATA LX456" , 8000, 7));
		productDaoFromJpaSpring.save(new Product("SDATA HP 654" , 500, 8));
		productDaoFromJpaSpring.save(new Product("SDATA HP 786" , 200, 5));
		
		//List<Product> products2  = productDaoFromJpaSpring.findAll();
		List<Product> products2  = productDaoFromJpaSpring.productsByKeyWord("%H%");
		for(Product p: products2) {
			System.out.println("Des: "+p.getDesignation());
			System.out.println("Price: "+p.getPrice());
		}
	
		/**
		 * Test category entities
		 */
		
		ICategoryJPARepository categoryJpaRepository = ctx.getBean(ICategoryJPARepository.class);
		
		Category c1 = new Category("Computer");
		Category c2 = new Category("Printer");
		Category c3 = new Category("Software");
		
		categoryJpaRepository.save(c1);
		categoryJpaRepository.save(c2);
		categoryJpaRepository.save(c3);
		
		productDaoFromJpaSpring.save(new Product("SDATA LX456" , 8000, 7, c1));
		productDaoFromJpaSpring.save(new Product("SDATA HP 654" , 500, 8, c1));
		productDaoFromJpaSpring.save(new Product("SDATA HP 786" , 200, 5, c3));
		
		
		
	}
}
