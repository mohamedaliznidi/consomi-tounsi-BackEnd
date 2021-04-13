package projet.pi.service;

import java.util.List;

import projet.pi.entity.Stock;




public interface StockServiceImp {
	
	public void addStock(Stock s);
	public void deleteStock(int i);
	public Stock updateStock(Stock s);
	public List<Stock> getAllStocks();
	public List<Long> missingProduct();
	public void orderProduct(long pid,int amount);
	
	

}