package tn.esprit.spring.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Basket;
import tn.esprit.spring.entities.ItemBasket;

@Repository
public interface ItemBasketRepository extends JpaRepository<ItemBasket, Integer> {
	List<ItemBasket> findByBasket(Basket basket);
	Optional<ItemBasket> findById(int id);

}
