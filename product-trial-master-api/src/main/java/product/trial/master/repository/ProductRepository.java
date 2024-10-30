package product.trial.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.trial.master.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
