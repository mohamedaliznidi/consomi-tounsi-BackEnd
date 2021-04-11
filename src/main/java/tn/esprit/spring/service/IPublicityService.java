package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.PublicityCategory;

public interface IPublicityService {
	
	Publicity addPublicity(Publicity p);
	void deletePublicity(int id);
	Publicity retrievePublicity(int id);
	void updatePublicity(Publicity p);
	List<Publicity> retrieveAllPublicities();
	List<Publicity> retrieveByPublicityCategory(PublicityCategory publicitycategory);

}
