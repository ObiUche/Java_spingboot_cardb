package com.packt.cardatabase.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.packt.cardatabase.domain.Car;
import org.springframework.web.bind.annotation.RestController;
import com.packt.cardatabase.domain.CarRepository;

@RequestMapping("/api")
@RestController
public class CarController {
	private final CarRepository repository;
	
	public CarController(CarRepository repository){
		this.repository = repository;
		
	}
	@GetMapping("/custom-cars")
	public Iterable<Car> getCars(){
		return repository.findAll();
		// Fetch and return cars
	}

}
