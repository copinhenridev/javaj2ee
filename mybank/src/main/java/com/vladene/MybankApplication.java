
package com.vladene;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author henri.tala
 *
 */
@SpringBootApplication
//@ImportResource("spring-beans.xml")
public class MybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybankApplication.class, args);
	}
}
