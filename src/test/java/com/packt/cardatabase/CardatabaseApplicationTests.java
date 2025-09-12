package com.packt.cardatabase;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import com.packt.cardatabase.web.CarController;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CardatabaseApplicationTests {
	@Autowired
	private CarController controller;
	

	@Test
	@DisplayName("First example test case")
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
