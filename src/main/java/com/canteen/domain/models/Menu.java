package src.main.java.com.canteen.domain.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Menu {
    private Long menuId;
    private Long dishId;
    private LocalDate date;
    private Integer availableQuantity;
    private LocalDateTime createdAt;

    public Menu() {}

    public Menu(Long menuId, Long dishId, LocalDate date, Integer availableQuantity) {
        this.menuId = menuId;
        this.dishId = dishId;
        this.date = date;
        this.availableQuantity = availableQuantity;
        this.createdAt = LocalDateTime.now();
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
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
        Menu menu = (Menu) o;
        return Objects.equals(menuId, menu.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", dishId=" + dishId +
                ", date=" + date +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}