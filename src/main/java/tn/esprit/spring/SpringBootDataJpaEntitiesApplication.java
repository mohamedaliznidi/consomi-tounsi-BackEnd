package tn.esprit.spring;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD:src/main/java/tn/esprit/spring/entities/SpringBootDataJpaEntitiesApplication.java
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
=======
import org.springframework.scheduling.annotation.EnableScheduling;


>>>>>>> jihene:src/main/java/tn/esprit/spring/SpringBootDataJpaEntitiesApplication.java

@SpringBootApplication
@EnableScheduling
public class SpringBootDataJpaEntitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaEntitiesApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
