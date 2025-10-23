package src.main.java.com.canteen.domain.repositories;

import src.main.java.com.canteen.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);
    List<Product> findProductsRunningLow();
    List<Product> findByWarehouseId(Long warehouseId);
    List<Product> findByName(String name);
}
