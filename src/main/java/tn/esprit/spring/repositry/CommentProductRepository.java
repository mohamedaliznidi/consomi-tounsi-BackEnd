package tn.esprit.spring.repositry;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CommentProduct;
import tn.esprit.spring.entities.CommentProductId;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.entities.PublicityCategory;

@Repository
public interface CommentProductRepository extends JpaRepository<CommentProduct, CommentProductId> {
	
	List<CommentProduct> findByProduct(Product product);
}