package src.main.java.com.canteen.domain.models;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private Long productId;
    private String name;
    private String unit;
    private Long providerId;
    private Long warehouseId;
    private BigDecimal currentQuantity;
    private BigDecimal minQuantity;
    private LocalDate expirationDate;
    private LocalDate lastDeliveryDate;
    private LocalDateTime createdAt;

    public Product() {}

    public Product(Long productId, String name, String unit, Long providerId,
                   Long warehouseId, BigDecimal currentQuantity, BigDecimal minQuantity) {
        this.productId = productId;
        this.name = name;
        this.unit = unit;
        this.providerId = providerId;
        this.warehouseId = warehouseId;
        this.currentQuantity = currentQuantity;
        this.minQuantity = minQuantity;
        this.createdAt = LocalDateTime.now();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public BigDecimal getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(BigDecimal currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public BigDecimal getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(BigDecimal minQuantity) {
        this.minQuantity = minQuantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getLastDeliveryDate() {
        return lastDeliveryDate;
    }

    public void setLastDeliveryDate(LocalDate lastDeliveryDate) {
        this.lastDeliveryDate = lastDeliveryDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", currentQuantity=" + currentQuantity +
                ", minQuantity=" + minQuantity +
                '}';
    }
}
