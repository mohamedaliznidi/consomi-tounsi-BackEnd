package tn.esprit.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Basket;
import tn.esprit.spring.repositry.BasketRepository;
import tn.esprit.spring.repositry.ItemBasketRepository;

@Service
public class BasketServiceImpl implements BasketService{
	@Autowired
	BasketRepository basketRepository ;
	@Autowired
	ItemBasketRepository itemBasketRepository ;

	@Override
	public List<Basket> getAll() {
		// TODO Auto-generated method stub
		return (List<Basket>) basketRepository.findAll();
	}

	@Override
	public Map<String,Object> getBasket(int id) {
		Basket basket = new Basket();
		Map<String,Object> map = new HashMap<>();
		basket =   basketRepository.findById(id).get();
		map.put("basket",basket); 
		map.put("items", itemBasketRepository.findByBasket(basket));
		return map ;
	}

	@Override
	public Basket updateBasket(Basket basket) {
		return basketRepository.save(basket);		
	}

	@Override
	public Basket addBasket(Basket basket) {
		return basketRepository.save(basket);
	}

	@Override
	public void deleteBasket(int id) {
		 basketRepository.deleteById(id);
		
	}

}
