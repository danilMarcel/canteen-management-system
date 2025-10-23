package src.main.java.com.canteen.domain.repositories;


import src.main.java.com.canteen.domain.models.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository {
    List<Warehouse> findAll();
    Optional<Warehouse> findById(Long id);
    Warehouse save(Warehouse warehouse);
    void delete(Long id);
    List<Warehouse> findByName(String name);
}