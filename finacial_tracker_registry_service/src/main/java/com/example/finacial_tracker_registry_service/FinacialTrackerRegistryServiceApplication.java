package com.example.finacial_tracker_registry_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FinacialTrackerRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinacialTrackerRegistryServiceApplication.class, args);
	}

}
