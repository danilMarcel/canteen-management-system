package src.main.java.com.canteen.domain.repositories;

import src.main.java.com.canteen.domain.models.Menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    List<Menu> findAll();
    Optional<Menu> findById(Long id);
    Menu save(Menu menu);
    void delete(Long id);
    List<Menu> findByDate(LocalDate date);
    List<Menu> findByDishId(Long dishId);
}