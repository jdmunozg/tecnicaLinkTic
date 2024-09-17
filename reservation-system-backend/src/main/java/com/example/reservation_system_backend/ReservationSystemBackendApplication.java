package com.example.reservation_system_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableSwagger2
public class ReservationSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationSystemBackendApplication.class, args);
	}

}
