package src.main.java.com.canteen.domain.models;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class DishProduct {
    private Long dishProductId;
    private Long dishId;
    private Long productId;
    private BigDecimal quantity;
    private String unit;
    private LocalDateTime createdAt;

    public DishProduct() {}

    public DishProduct(Long dishId, Long productId, BigDecimal quantity, String unit) {
        this.dishId = dishId;
        this.productId = productId;
        this.quantity = quantity;
        this.unit = unit;
        this.createdAt = LocalDateTime.now();
    }

    public Long getDishProductId() {
        return dishProductId;
    }

    public void setDishProductId(Long dishProductId) {
        this.dishProductId = dishProductId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
        DishProduct that = (DishProduct) o;
        return Objects.equals(dishProductId, that.dishProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishProductId);
    }

    @Override
    public String toString() {
        return "DishProduct{" +
                "dishId=" + dishId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}