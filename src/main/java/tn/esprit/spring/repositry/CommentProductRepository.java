package tn.esprit.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CommentProduct;
import tn.esprit.spring.entities.CommentProductId;
import tn.esprit.spring.entities.Product;

@Repository
public interface CommentProductRepository extends JpaRepository<CommentProduct, CommentProductId> {
	List<CommentProduct> findByClient(int idclient);
	List<CommentProduct> findByProduct(int idproduct);

}
