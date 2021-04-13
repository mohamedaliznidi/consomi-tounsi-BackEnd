package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.OrderC;

public interface OrderCService {
	List<OrderC>allListOrderC();
	OrderC getOrderC(int id);
	void updateOrderC(OrderC orderC);
	void addOrderC(OrderC orderC);
	List<OrderC> search(String search);
	void deleteOrder(int OrderId);
	List<OrderC> getAllEntreprises();
	
}
