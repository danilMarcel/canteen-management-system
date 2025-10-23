package src.main.java.com.canteen.domain.inmemory;


import src.main.java.com.canteen.domain.models.Product;
import src.main.java.com.canteen.domain.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryProductRepository implements ProductRepository {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public InMemoryProductRepository() {
        initializeTestData();
    }

    private void initializeTestData() {
        save(new Product(1L, "Картофель", "кг", 1L, 1L, new BigDecimal("5.0"), new BigDecimal("10.0")));
        save(new Product(2L, "Морковь", "кг", 1L, 1L, new BigDecimal("15.0"), new BigDecimal("5.0")));
        save(new Product(3L, "Говядина", "кг", 2L, 1L, new BigDecimal("25.5"), new BigDecimal("8.0")));
        save(new Product(4L, "Лук", "кг", 1L, 1L, new BigDecimal("3.0"), new BigDecimal("5.0")));
        save(new Product(5L, "Сметана", "л", 3L, 2L, new BigDecimal("8.0"), new BigDecimal("2.0")));
        save(new Product(6L, "Молоко", "л", 3L, 2L, new BigDecimal("12.0"), new BigDecimal("5.0")));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public Product save(Product product) {
        if (product.getProductId() == null) {
            product.setProductId(idGenerator.getAndIncrement());
        }
        products.put(product.getProductId(), product);
        return product;
    }

    @Override
    public void delete(Long id) {
        products.remove(id);
    }

    @Override
    public List<Product> findProductsRunningLow() {
        return products.values().stream()
                .filter(product -> product.getCurrentQuantity().compareTo(product.getMinQuantity()) <= 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByWarehouseId(Long warehouseId) {
        return products.values().stream()
                .filter(product -> product.getWarehouseId().equals(warehouseId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByName(String name) {
        return products.values().stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}