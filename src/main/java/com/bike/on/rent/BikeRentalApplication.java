package com.bike.on.rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // @Configuration + @ComponentScan + @EnableAutoConfiguration
public class BikeRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeRentalApplication.class, args);
		System.out.println("Welcome Server is started now !!");
	}

}
