package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.DeliveryMan;

public interface IDeliveryManService {
	DeliveryMan addDeliveryMan(DeliveryMan dm);
	DeliveryMan updateDeliveryMan(DeliveryMan dm);
	void deleteDeliveryMan(int id);
	void retrieveDeliveryMan(int id);
	List<DeliveryMan> retrieveAllDeliveryMan();
	List<DeliveryMan> retrieveByName(String name);

}
