package src.main.java.com.canteen.domain.repositories;

import src.main.java.com.canteen.domain.models.DishProduct;

import java.util.List;
import java.util.Optional;

public interface DishProductRepository {
    List<DishProduct> findAll();
    Optional<DishProduct> findById(Long id);
    DishProduct save(DishProduct dishProduct);
    void delete(Long id);
    List<DishProduct> findByDishId(Long dishId);
    List<DishProduct> findByProductId(Long productId);
}
