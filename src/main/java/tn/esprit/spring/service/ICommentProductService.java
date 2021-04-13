package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.CommentProduct;
import tn.esprit.spring.entities.CommentProductId;
import tn.esprit.spring.entities.Product;

public interface ICommentProductService {
	void addCommentProduct(CommentProduct comment);
	List<CommentProduct> retrieveAllCommentProduct();
	List<CommentProduct> RetrieveByProduct(int idProduct);
	public void deleteCommentProduct(int idproduct, int idclient,Date date);
}
