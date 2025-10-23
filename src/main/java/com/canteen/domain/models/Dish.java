package src.main.java.com.canteen.domain.models;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Dish {
    private Long dishId;
    private String name;
    private String description;
    private Integer cookingTime;
    private BigDecimal price;
    private LocalDateTime createdAt;

    public Dish() {}

    public Dish(Long dishId, String name, String description, Integer cookingTime, BigDecimal price) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.cookingTime = cookingTime;
        this.price = price;
        this.createdAt = LocalDateTime.now();
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        Dish dish = (Dish) o;
        return Objects.equals(dishId, dish.dishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}