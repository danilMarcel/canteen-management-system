package src.main.java.com.canteen.domain.inmemory;

import src.main.java.com.canteen.domain.models.Warehouse;
import src.main.java.com.canteen.domain.repositories.WarehouseRepository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


public class InMemoryWarehouseRepository implements WarehouseRepository {
    private final Map<Long, Warehouse> warehouses = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public InMemoryWarehouseRepository() {
        initializeTestData();
    }

    private void initializeTestData() {
        save(new Warehouse(1L, "Основной склад", "г. Воронеж, ул. Центральная, д. 1"));
        save(new Warehouse(2L, "Холодильный склад", "г. Воронеж, ул. Центральная, д. 2"));
        save(new Warehouse(3L, "Овощной склад", "г. Воронеж, ул. Зеленая, д. 15"));
    }

    @Override
    public List<Warehouse> findAll() {
        return new ArrayList<>(warehouses.values());
    }

    @Override
    public Optional<Warehouse> findById(Long id) {
        return Optional.ofNullable(warehouses.get(id));
    }

    @Override
    public Warehouse save(Warehouse warehouse) {
        if (warehouse.getWarehouseId() == null) {
            warehouse.setWarehouseId(idGenerator.getAndIncrement());
        }
        warehouses.put(warehouse.getWarehouseId(), warehouse);
        return warehouse;
    }

    @Override
    public void delete(Long id) {
        warehouses.remove(id);
    }

    @Override
    public List<Warehouse> findByName(String name) {
        return warehouses.values().stream()
                .filter(warehouse -> warehouse.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
