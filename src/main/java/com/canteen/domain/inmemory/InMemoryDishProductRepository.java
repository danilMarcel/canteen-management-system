package src.main.java.com.canteen.domain.inmemory;

import src.main.java.com.canteen.domain.models.DishProduct;
import src.main.java.com.canteen.domain.repositories.DishProductRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryDishProductRepository implements DishProductRepository {
    private final Map<Long, DishProduct> dishProducts = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public InMemoryDishProductRepository() {
        initializeTestData();
    }

    private void initializeTestData() {
        // Тестовые данные для связей блюд и продуктов
        save(new DishProduct(1L, 1L, new java.math.BigDecimal("0.3"), "кг")); // Борщ - Картофель
        save(new DishProduct(2L, 2L, new java.math.BigDecimal("0.2"), "кг")); // Борщ - Морковь
        save(new DishProduct(1L, 3L, new java.math.BigDecimal("0.15"), "кг")); // Котлета - Говядина
    }

    @Override
    public List<DishProduct> findAll() {
        return new ArrayList<>(dishProducts.values());
    }

    @Override
    public Optional<DishProduct> findById(Long id) {
        return Optional.ofNullable(dishProducts.get(id));
    }

    @Override
    public DishProduct save(DishProduct dishProduct) {
        if (dishProduct.getDishProductId() == null) {
            dishProduct.setDishProductId(idGenerator.getAndIncrement());
        }
        dishProducts.put(dishProduct.getDishProductId(), dishProduct);
        return dishProduct;
    }

    @Override
    public void delete(Long id) {
        dishProducts.remove(id);
    }

    @Override
    public List<DishProduct> findByDishId(Long dishId) {
        return dishProducts.values().stream()
                .filter(dp -> dp.getDishId().equals(dishId))
                .collect(Collectors.toList());
    }

    @Override
    public List<DishProduct> findByProductId(Long productId) {
        return dishProducts.values().stream()
                .filter(dp -> dp.getProductId().equals(productId))
                .collect(Collectors.toList());
    }
}