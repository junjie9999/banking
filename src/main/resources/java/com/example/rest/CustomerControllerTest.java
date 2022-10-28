
package com.example.rest;

	import static org.assertj.core.api.Assertions.assertThat;

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

import com.example.rest.controller.CustomerController;



	@SpringBootTest
	public class CustomerControllerTest {
	
		@Autowired
		private CustomerController controller;
		
		@Test
		public void controllerInitCorrectly() //Checks that REST controller has been initialised
		{
			assertThat(controller).isNotNull();
		}
	}

