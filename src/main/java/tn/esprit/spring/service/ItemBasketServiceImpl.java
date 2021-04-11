package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Basket;
import tn.esprit.spring.entities.ItemBasket;
import tn.esprit.spring.repositry.BasketRepository;
import tn.esprit.spring.repositry.ItemBasketRepository;
import tn.esprit.spring.repositry.ProductRepository;

@Service
public class ItemBasketServiceImpl implements ItemBasketService {

	@Autowired
	ItemBasketRepository itemBasketRepository ;
	@Autowired
	ProductRepository productRepository ;
	@Autowired
	BasketRepository basketRepository ;
	
	@Override
	public List<ItemBasket> getAll() {
		// TODO Auto-generated method stub
		return  itemBasketRepository.findAll();
	}

	@Override
	public ItemBasket getItem(int id) {
		Optional<ItemBasket> optionalItem = itemBasketRepository.findById(id);
		if (optionalItem.isPresent()) {
			return optionalItem.get();
		}
		return null;
	}

	@Override
	public void updateItem(ItemBasket itemBasket) {
		itemBasketRepository.save(itemBasket);
		
	}

	@Override
	public ItemBasket addItem(ItemBasket itemBasket) {
		System.out.println(itemBasket.getBasket());
		if (itemBasket.getBasket()==null) {
			Basket b = new Basket() ;
			b.setStateBasket(true);
			b = basketRepository.save(b);
			itemBasket.setBasket(b);
		}else {
			itemBasket.setBasket(basketRepository.findById(itemBasket.getBasket().getId()).get());
		}
		itemBasket.setProduct(productRepository.findById(itemBasket.getProduct().getId()).get());
		System.out.println(itemBasket);
		itemBasket = itemBasketRepository.save(itemBasket);
		System.out.println(itemBasket);
		//basketRepository.findById(itemBasket.getBasket().getId()).get().getItems().add(itemBasket);
		return itemBasket ;
		}
	
	@Override
	public List<ItemBasket> getItemsByBasketId(int id){
		Basket b = basketRepository.findById(id).get();
		System.out.println(b);
		return itemBasketRepository.findByBasket(b);
	}

	@Override
	public void deleteItem(int id) {
		itemBasketRepository.deleteById(id);
		
	}

}
