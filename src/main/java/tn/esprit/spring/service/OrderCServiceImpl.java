package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.ItemBasket;
import tn.esprit.spring.entities.OrderC;
import tn.esprit.spring.repositry.BasketRepository;
import tn.esprit.spring.repositry.ItemBasketRepository;
import tn.esprit.spring.repositry.OrderCRepository;

@Service
public class OrderCServiceImpl implements OrderCService  {
	@Autowired
	OrderCRepository orderCRepository;
	@Autowired
	ItemBasketRepository itemBasketRepository;
	@Autowired
	BasketRepository basketRepository;

	@Override
	public List<OrderC> allListOrderC() {
		System.out.println((List<OrderC>)orderCRepository.findAll());
		
		return (List<OrderC>)orderCRepository.findAll();
	}


	@Override
	public List<OrderC> getAllEntreprises() {
		
		

			List<OrderC> orders =  (List<OrderC>) orderCRepository.findAll();
		
			for (OrderC ent : orders) {
				System.out.println(ent);
				
			}
			

		return orders;
	}
	
	
	
	@Override
	public void updateOrderC(OrderC orderC) {
		// TODO Auto-generated method stub
		if (orderCRepository.existsById(orderC.getId())) {
			orderCRepository.save(orderC);
		}	
	}

	@Override
	public void addOrderC(OrderC orderC) {
		// TODO Auto-generated method stub
		orderC.setDelivered(false);
		orderC.setTotalPrice(0);
		orderC.setTaxPrice(7);
		float total = 0 ;
		if(orderC.getPaymentMethode().equals("CASH"))
			orderC.setPaid(false);
		else {
			orderC.setPaid(true);
			orderC.setPaidAt(new Date());
		}
		orderC.setBasket(basketRepository.findById(orderC.getBasket().getId()).get());
		List<ItemBasket> items = itemBasketRepository.findByBasket(orderC.getBasket());
		for (ItemBasket i : items)
			total += i.getProduct().getPrice() * i.getQuantity() + (i.getProduct().getPrice() * i.getQuantity()* orderC.getTaxPrice())/100 ;
		orderC.setTotalPrice(total);
		orderCRepository.save(orderC);
		
	}

	@Override
	public List<OrderC> search(String search) {
		// TODO Auto-generated method stub
		List<OrderC> orderCSearch= new ArrayList<>();
		for(OrderC ord: (List<OrderC>)orderCRepository.findAll()){
			String s = ord.getPaymentMethode() +"";
			if  (s.toUpperCase().contains(search.toUpperCase())){
				orderCSearch.add(ord);
		}}
		return orderCSearch;
		
	}

	@Override
	public void deleteOrder(int OrderId) {
		// TODO Auto-generated method stub
		orderCRepository.deleteById(OrderId);
		
	}

	@Override
	public OrderC getOrderC(int id) {
		// TODO Auto-generated method stub
		return orderCRepository.findById(id).get();
	}

	
}
