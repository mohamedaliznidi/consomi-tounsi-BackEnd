package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.PublicityCategory;
import tn.esprit.spring.repositry.ProductRepository;
import tn.esprit.spring.repositry.PublicityRepository;

@Service
public class PublicityServiceImpl implements IPublicityService {
	
		
		@Autowired
		PublicityRepository publicityRepository;
		
		 private static final Logger L = LogManager.getLogger(PublicityServiceImpl.class);
		
		@Override
		public Publicity addPublicity (Publicity p){
			return publicityRepository.save(p);
		}
		
		@Override
		public void deletePublicity(int id){
			publicityRepository.deleteById(id);
			
		}
		
		@Override
		public void updatePublicity(Publicity p){
			 publicityRepository.save(p);
		}
		
		@Override
		public Publicity retrievePublicity(int id){
			return publicityRepository.findById(id).get();
			
		}
		@Override
		public List<Publicity> retrieveAllPublicities(){
			List<Publicity> publicities = (List<Publicity>) publicityRepository.findAll();
			for (Publicity publicity : publicities){
				L.info("publicity +++ : " +publicity);
			}
			return publicities;
			
			}
		
		
		
	
		@Override
		public List<Publicity> retrieveByPublicityCategory(PublicityCategory publicitycategory){
			List<Publicity> publicities=publicityRepository.findByPublicitycategory(publicitycategory);
			return publicities;
		}
		
		@Scheduled(fixedRate = 10000) 
		public void invokeScheduled() {
			Date Today=new java.util.Date();  
			List<Publicity> publicities =  (List<Publicity>) publicityRepository.findAll();

			for (Publicity p2 : publicities){

				if ((p2.getStartDateP().before(Today)) && (p2.getEndDateP().after(Today))){
					p2.setCurrent(true);
					publicityRepository.save(p2);


				}

			}

		}
}
