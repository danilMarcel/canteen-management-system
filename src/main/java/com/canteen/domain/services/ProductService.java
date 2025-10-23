package src.main.java.com.canteen.domain.services;


import src.main.java.com.canteen.domain.models.Product;
import src.main.java.com.canteen.domain.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsRunningLow() {
        return productRepository.findProductsRunningLow();
    }

    public Product createProduct(String name, String unit, Long providerId,
                                 Long warehouseId, BigDecimal currentQuantity, BigDecimal minQuantity) {
        Product product = new Product(null, name, unit, providerId, warehouseId, currentQuantity, minQuantity);
        return productRepository.save(product);
    }

    public boolean updateProductQuantity(Long productId, BigDecimal newQuantity) {
        return productRepository.findById(productId)
                .map(product -> {
                    product.setCurrentQuantity(newQuantity);
                    productRepository.save(product);
                    return true;
                })
                .orElse(false);
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getProductsByWarehouse(Long warehouseId) {
        return productRepository.findByWarehouseId(warehouseId);
    }
}