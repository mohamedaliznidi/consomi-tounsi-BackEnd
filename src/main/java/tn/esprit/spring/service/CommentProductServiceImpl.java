package tn.esprit.spring.service;

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
	
	 private static final Logger L = LogManager.getLogger(ProductServiceImpl.class);
	
	@Override
	public CommentProduct addCommentProduct (CommentProduct p){
		return commentproductRepository.save(p);
	}
	@Override
	public void deleteCommentProduct(CommentProductId id){
		commentproductRepository.deleteById(id);
		
	}
	
	@Override
	public CommentProduct updateCommentProduct(CommentProduct p){
		return commentproductRepository.save(p);
	}
	
	@Override
	public void retrieveCommentProduct(CommentProductId id){
		commentproductRepository.findById(id);
		
	}
	@Override
	public List<CommentProduct> retrieveAllCommentProduct(){
		List<CommentProduct> comments = (List<CommentProduct>) commentproductRepository.findAll();
		/**for (Product product : products){
			L.info("product +++ : " +user);
		}*/
		return comments;
		
		}
	@Override
	public List<CommentProduct> RetrieveByClient(int idclient){
		List<CommentProduct> comments = (List<CommentProduct>) commentproductRepository.findByClient(idclient);
		/**for (Product product : products){
		L.info("product +++ : " +user);
	}*/
		return comments;
	}
	
	@Override
	public List<CommentProduct> RetrieveByProduct(int idproduct){
		List<CommentProduct> comments = (List<CommentProduct>) commentproductRepository.findByClient(idproduct);
		/**for (Product product : products){
		L.info("product +++ : " +user);
	}*/
		return comments;
		
	}
	
	

}
