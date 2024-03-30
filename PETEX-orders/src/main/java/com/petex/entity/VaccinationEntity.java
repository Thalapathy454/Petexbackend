package com.petex.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders_TAB")
public class VaccinationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    
    private String product;

    private Long price;

    private String quantity;
    private Long total;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public VaccinationEntity() {
        super();
    }

    public VaccinationEntity(Integer customerId, String product, Long price, String quantity, Long total) {
        super();
        this.customerId = customerId;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    @Override
    public String toString() {
        return "VaccinationEntity [customerId=" + customerId + ", product=" + product + ", price=" + price
                + ", quantity=" + quantity + ", total=" + total + "]";
    }
}
