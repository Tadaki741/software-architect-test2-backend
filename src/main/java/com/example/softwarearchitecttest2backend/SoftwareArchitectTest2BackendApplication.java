package com.example.softwarearchitecttest2backend;

import com.example.softwarearchitecttest2backend.MPO.MPO;
import com.example.softwarearchitecttest2backend.MPO.MPORepository;
import com.example.softwarearchitecttest2backend.ManufacturingOrder.MORepository;
import com.example.softwarearchitecttest2backend.ManufacturingOrder.ManufacturingOrder;
import com.example.softwarearchitecttest2backend.Product.Product;
import com.example.softwarearchitecttest2backend.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SoftwareArchitectTest2BackendApplication {

	@Autowired
	private ProductRepository productRepository;


	@Autowired
	private MORepository moRepository;


	@Autowired
	private MPORepository mpoRepository;


	public static void main(String[] args) {
		SpringApplication.run(SoftwareArchitectTest2BackendApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner () {
		return args -> {

			//Add some fake data to the product table
			Product product1 = new Product("7812367213","chair","an object to sit down","furniture",5, 100);
			Product product2 = new Product("9345834958","hair dryer","object to dry wet hair","electronic",3,50);
			Product product3 = new Product("2109381092","pen","use to draw","stationary",10,5);
			Product product4 = new Product("0129310283","table","multipurpose table","furniture",6,30);
			Product product5 = new Product("1029382102","frying pan","a tool to cook food","kitchen",2,30);
			Product product6 = new Product("9812783129","air fryer","god savior tool","kitchen",7,120);
			Product product7 = new Product("0129012922","cue tips","use to clean the ears","accessories",2,10);
			Product product8 = new Product("1109208290","table lamp","environmental illumination device","electronics",3,15);
			Product product9 = new Product("0912839292","wall clock","use to tell time","kitchen",7,10);
			Product product10 = new Product("1928828122","jacket","personal clothing","clothing",7,120);

			//Repo
			this.productRepository.save(product1);
			this.productRepository.save(product2);
			this.productRepository.save(product3);
			this.productRepository.save(product4);
			this.productRepository.save(product5);
			this.productRepository.save(product6);
			this.productRepository.save(product7);
			this.productRepository.save(product8);
			this.productRepository.save(product9);
			this.productRepository.save(product10);

			//Add some fake data to the manufacturing order table
			String sDate1="31/12/2023";
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			ManufacturingOrder manufacturingOrder = new ManufacturingOrder("VoDaiDuong",date1,date1,date1,"undone", product1);
			ManufacturingOrder manufacturingOrder3 = new ManufacturingOrder("MaiDucMinh",date1,date1,date1,"undone", product5);
			ManufacturingOrder manufacturingOrder4 = new ManufacturingOrder("NguyenQuocBinh",date1,date1,date1,"undone", product6);
			ManufacturingOrder manufacturingOrder1 = new ManufacturingOrder("NguyenQuocHoangTrung",date1,date1,date1,"undone", product2);
			ManufacturingOrder manufacturingOrder2 = new ManufacturingOrder("TranDangKhoa",date1,date1,date1,"undone", product4);
			this.moRepository.save(manufacturingOrder);
			this.moRepository.save(manufacturingOrder2);
			this.moRepository.save(manufacturingOrder3);
			this.moRepository.save(manufacturingOrder4);
			this.moRepository.save(manufacturingOrder1);


			//Table add some fake data to the Material Purchase Order
			MPO mpo = new MPO("undone",product2);
			MPO mpo2 = new MPO("undone",product2);
			MPO mpo3 = new MPO("undone",product5);
			MPO mpo4 = new MPO("undone",product6);
			MPO mpo1 = new MPO("undone",product1);


			//Save
			this.mpoRepository.save(mpo);
			this.mpoRepository.save(mpo3);
			this.mpoRepository.save(mpo4);
			this.mpoRepository.save(mpo1);
			this.mpoRepository.save(mpo2);

		};
	}

}
