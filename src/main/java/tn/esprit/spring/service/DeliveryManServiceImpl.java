package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.DeliveryMan;
import tn.esprit.spring.repositry.DeliveryManRepository;

public class DeliveryManServiceImpl implements IDeliveryManService {

	@Autowired
	DeliveryManRepository deliveryManRepository;
	
	@Override
	public DeliveryMan addDeliveryMan(DeliveryMan dm) {
		
		return deliveryManRepository.save(dm);
	}

	@Override
	public DeliveryMan updateDeliveryMan(DeliveryMan dm) {

		return deliveryManRepository.save(dm);
	}

	@Override
	public void deleteDeliveryMan(int id) {
		deliveryManRepository.deleteById(id);
		
	}

	@Override
	public void retrieveDeliveryMan(int id) {
		deliveryManRepository.findById(id);
		
	}

	@Override
	public List<DeliveryMan> retrieveAllDeliveryMan() {
		List<DeliveryMan> deliveryMans = (List<DeliveryMan>) deliveryManRepository.findAll();
		return deliveryMans;
	}

	@Override
	public List<DeliveryMan> retrieveByName(String name) {
		List<DeliveryMan> deliveryMans =  deliveryManRepository.findByUserName(name);
		return deliveryMans;
	}

}
