package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.PublicityCategory;

public interface IPublicityService {
	
	Publicity addPublicity(Publicity p);
	void deletePublicity(int id);
	void retrievePublicity(int id);
	Publicity updatePublicity(Publicity p);
	List<Publicity> retrieveAllPublicities();
	List<Publicity> retrieveByPublicityCategory(PublicityCategory publicitycategory);

}
