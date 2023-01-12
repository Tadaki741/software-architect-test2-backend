package com.example.softwarearchitecttest2backend;

import com.example.softwarearchitecttest2backend.Product.Product;
import com.example.softwarearchitecttest2backend.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoftwareArchitectTest2BackendApplication {

	@Autowired
	private ProductRepository productRepository;




	public static void main(String[] args) {
		SpringApplication.run(SoftwareArchitectTest2BackendApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner () {
		return args -> {

			//Add some fake data to the product table
			Product product1 = new Product("7812367213","chair","an object to sit down","furniture",5,"none");
			Product product2 = new Product("9345834958","hair dryer","object to dry wet hair","electronic",3,"none");
			Product product3 = new Product("2109381092","pen","use to draw","stationary",10,"none");
			Product product4 = new Product("0129310283","table","multipurpose table","furniture",6,"none");
			Product product5 = new Product("1029382102","frying pan","a tool to cook food","kitchen",2,"none");
			Product product6 = new Product("3478563478","air fryer","god savior tool","kitchen",7,"none");

			//Repo
			this.productRepository.save(product1);
			this.productRepository.save(product2);
			this.productRepository.save(product3);
			this.productRepository.save(product4);
			this.productRepository.save(product5);
			this.productRepository.save(product6);

		};
	}

}
