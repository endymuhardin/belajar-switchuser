package com.muhardin.endy.belajar.switchuser.belajarswitchuser;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BelajarSwitchuserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSwitchuserApplication.class, args);
	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}
