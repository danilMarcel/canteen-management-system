package src.main.java.com.canteen.domain.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Provider {
    private Long providerId;
    private String name;
    private String address;
    private String contactPerson;
    private String phone;
    private LocalDateTime createdAt;

    public Provider() {}

    public Provider(Long providerId, String name, String address, String contactPerson, String phone) {
        this.providerId = providerId;
        this.name = name;
        this.address = address;
        this.contactPerson = contactPerson;
        this.phone = phone;
        this.createdAt = LocalDateTime.now();
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        Provider provider = (Provider) o;
        return Objects.equals(providerId, provider.providerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerId);
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerId=" + providerId +
                ", name='" + name + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}