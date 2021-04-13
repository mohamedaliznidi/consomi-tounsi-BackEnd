package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Stock;




public interface StockServiceImp {
	
	public int addStock(Stock s);
	public void deleteStock(int i);
	public Stock updateStock(Stock s);
	public List<Stock> getAllStocks();
	public List<Long> missingProduct();
	public void orderProduct(long pid,int amount);
	
	

}