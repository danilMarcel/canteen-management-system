package src.main.java.com.canteen.domain.models;



import java.time.LocalDateTime;
import java.util.Objects;

public class Warehouse {
    private Long warehouseId;
    private String name;
    private String address;
    private LocalDateTime createdAt;

    public Warehouse() {}

    public Warehouse(Long warehouseId, String name, String address) {
        this.warehouseId = warehouseId;
        this.name = name;
        this.address = address;
        this.createdAt = LocalDateTime.now();
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(warehouseId, warehouse.warehouseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}