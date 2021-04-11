package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entities.ItemBasket;

public interface ItemBasketService {

	List<ItemBasket>getAll();
	ItemBasket getItem(int id);
	void updateItem(ItemBasket itemBasket);
	ItemBasket addItem(ItemBasket itemBasket);
	void deleteItem(int id);
	List<ItemBasket> getItemsByBasketId(int id);
}
