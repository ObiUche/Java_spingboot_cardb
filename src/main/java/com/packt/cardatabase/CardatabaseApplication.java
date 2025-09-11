package com.packt.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.AppUser;
import com.packt.cardatabase.domain.AppUserRepository;
import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(
			CardatabaseApplication.class
			);
	private final CarRepository repository;
	private final OwnerRepository orepository;
	private final AppUserRepository urepository;
	
	public CardatabaseApplication(CarRepository repository, OwnerRepository orepository, AppUserRepository urepository) {
		this.repository = repository;
		this.orepository = orepository;
		this.urepository = urepository;
		
	}
	public static void main(String[] args) {
		// After adding this comment the application is restarted
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}
	
	//Cardatabase Application.java run method
	@Override
	public void run(String... args)throws Exception{
		// Add owner objects and save these to db
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));
		
		repository.save(new Car("Ford", "Mustang","Red","ADF-1121",2023,59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
		repository.save(new Car("Toyota", "Prius", "Sliver", "KKO-0212", 2022, 39000, owner2));
		
		// Fetch all cars and log to console
		
		for (Car car: repository.findAll()) {
			logger.info("brand: {}, model: {}",car.getBrand(), car.getModel());
		}
		
		//Username: user, password: user
		urepository.save(new AppUser("user", "$2y$10$PVRIFvt/y2KdIS3q2kyJzupq2apxTPbj2HbFuRMfC8oBZjhS0CkkS", "USER"));
		
		//Username: admin, password: admin
		urepository.save(new AppUser("admin", "$2y$10$2V1YkY9OqL85yEEYk5nih./fOr8D08GrIu/NGDhY2SyBP03YNM/TO", "ADMIN"));
		
		
	}

}
