
package tn.esprit.spring;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;


import com.google.maps.model.LatLng;

import tn.esprit.spring.data.MemoryStore;
import tn.esprit.spring.data.Store;
import tn.esprit.spring.entities.Deliveryman;
import tn.esprit.spring.service.GeocodeService;


import org.springframework.scheduling.annotation.EnableScheduling;
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
	@Bean(name = "geocodeService")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@ConfigurationProperties(prefix = "config")
	public GeocodeService getGeocodeService() {
		GeocodeService service = new GeocodeService();
		return service;
	}

	@Bean(name = "memoryStore")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Store<Deliveryman, LatLng> getMemoryStore() {
		return  new MemoryStore();
	}

}
