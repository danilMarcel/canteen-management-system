package src.main.java.com.canteen.domain.services;


import src.main.java.com.canteen.domain.models.Warehouse;
import src.main.java.com.canteen.domain.repositories.WarehouseRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import java.util.List;

public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse createWarehouse(String name, String address) {
        Warehouse warehouse = new Warehouse(null, name, address);
        return warehouseRepository.save(warehouse);
    }

    public List<Warehouse> searchWarehousesByName(String name) {
        return warehouseRepository.findByName(name);
    }

    public boolean deleteWarehouse(Long id) {
        try {
            warehouseRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}