package com.amaris.java_test.prices.core.application.domain;

import com.amaris.java_test.prices.core.application.domain.dto.PricesDto;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity

@SqlResultSetMapping(name = "PricesQueryMapping", classes = {
        @ConstructorResult(targetClass = PricesDto.class,
                columns = { @ColumnResult(name = "PRODUCT_ID", type = Integer.class),
                @ColumnResult(name = "BRAND_ID", type = Integer.class),
                @ColumnResult(name = "PRICE_LIST", type = Integer.class),
                @ColumnResult(name = "START_DATE", type = String.class),
                @ColumnResult(name = "END_DATE", type = String.class),
                @ColumnResult(name = "PRICE", type = Double.class)
        }) })

public class Prices implements Serializable {
    private Long id;
    private Long brandId;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private Double price;
    private String curr;

    @Id @Column(name = "ID") public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic @Column(name = "BRAND_ID") public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Basic @Column(name = "START_DATE") public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic @Column(name = "END_DATE") public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic @Column(name = "PRICE_LIST") public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    @Basic @Column(name = "PRODUCT_ID") public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic @Column(name = "PRIORITY") public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Basic @Column(name = "PRICE") public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic @Column(name = "CURR") public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Prices prices = (Prices) o;
        return Objects.equals(id, prices.id) && Objects.equals(brandId, prices.brandId) && Objects
                .equals(startDate, prices.startDate) && Objects.equals(endDate, prices.endDate) && Objects
                .equals(priceList, prices.priceList) && Objects.equals(productId, prices.productId) && Objects
                .equals(priority, prices.priority) && Objects.equals(price, prices.price) && Objects
                .equals(curr, prices.curr);
    }

    @Override public int hashCode() {
        return Objects.hash(id, brandId, startDate, endDate, priceList, productId, priority, price, curr);
    }
}
