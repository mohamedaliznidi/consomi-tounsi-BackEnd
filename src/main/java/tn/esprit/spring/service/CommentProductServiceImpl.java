package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.CommentProduct;
import tn.esprit.spring.entities.CommentProductId;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repositry.CommentProductRepository;
import tn.esprit.spring.repositry.ProductRepository;

@Service
public class CommentProductServiceImpl implements ICommentProductService {
	

	@Autowired
	CommentProductRepository commentproductRepository;
	
	@Autowired
	IProductService productservice;
	
	 private static final Logger L = LogManager.getLogger(ProductServiceImpl.class);
	
	@Override
	public void addCommentProduct (CommentProduct comment){
	/*	CommentProductId id = new CommentProductId();
		id.setIdClient(idclient);
		id.setIdProduct(idproduct);
		//Date date = new Date();
		id.setDate(date);
		CommentProduct comment = new CommentProduct();
		comment.setCommentproductid(id);*/
	commentproductRepository.save(comment);
	}
	
	
	@Override
	public void deleteCommentProduct(int idproduct, int idclient,Date date){
		CommentProductId id = new CommentProductId();
		id.setIdClient(idclient);
		id.setIdProduct(idproduct);
		id.setDate(date);
		commentproductRepository.deleteById(id);
		
	}
	

	

	@Override
	public List<CommentProduct> retrieveAllCommentProduct(){
		List<CommentProduct> comments = (List<CommentProduct>) commentproductRepository.findAll();

		return comments;
		
		}

	
	@Override
	public List<CommentProduct> RetrieveByProduct(int idProduct){
		Product product=productservice.retrieveProduct(idProduct);
		List<CommentProduct> comments = (List<CommentProduct>) commentproductRepository.findByProduct(product);

		return comments;
		
	}
	
	

}
