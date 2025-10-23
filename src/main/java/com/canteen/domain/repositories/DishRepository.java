package src.main.java.com.canteen.domain.repositories;

import src.main.java.com.canteen.domain.models.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository {
    List<Dish> findAll();
    Optional<Dish> findById(Long id);
    Dish save(Dish dish);
    void delete(Long id);
    List<Dish> findByName(String name);
}