package com.satendra.testcontainer;

import org.springframework.boot.SpringApplication;

public class TestTestContainerApplication {

	public static void main(String[] args) {
		SpringApplication.from(TestContainerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
