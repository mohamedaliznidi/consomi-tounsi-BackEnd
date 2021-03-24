package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.CommentProduct;
import tn.esprit.spring.entities.CommentProductId;
import tn.esprit.spring.entities.Product;

public interface ICommentProductService {
	CommentProduct addCommentProduct(CommentProduct p);
	void deleteCommentProduct(CommentProductId id);
	void retrieveCommentProduct(CommentProductId id);
	CommentProduct updateCommentProduct(CommentProduct p);
	List<CommentProduct> retrieveAllCommentProduct();
	List<CommentProduct> RetrieveByClient(int idclient);
	List<CommentProduct> RetrieveByProduct(int idproduct);
}
