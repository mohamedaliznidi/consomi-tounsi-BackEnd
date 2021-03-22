
 
/**import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.ProductCategory;
import tn.esprit.spring.repositry.ProductRepository;
 
@DataJpaTest
public class ProductRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private ProductRepository productrepository;
    ProductCategory productcategory;
    Date date;
     
    @Test
    public void addProduct() {
        entityManager.persist(new Product(15,"a","b",1,"hh",5,"24/04/2016",date,productcategory));
                 

    }
}
*/