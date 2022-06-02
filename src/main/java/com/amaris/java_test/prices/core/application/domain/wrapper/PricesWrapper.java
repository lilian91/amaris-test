package com.amaris.java_test.prices.core.application.domain.wrapper;

import java.sql.Timestamp;

public class PricesWrapper {

    private String applicationDate;
    private Integer productId;
    private Integer brandId;

    public PricesWrapper() {
    }

    public PricesWrapper(String applicationDate, Integer productId, Integer brandId) {
        this.applicationDate = applicationDate;
        this.productId = productId;
        this.brandId = brandId;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
