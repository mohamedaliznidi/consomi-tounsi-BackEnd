package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;

import tn.esprit.spring.entities.Basket;

public interface BasketService {

	List<Basket>getAll();
	Map<String, Object> getBasket(int id);
	Basket updateBasket(Basket basket);
	Basket addBasket(Basket basket);
	void deleteBasket(int id);
}
