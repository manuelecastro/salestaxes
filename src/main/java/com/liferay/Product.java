package com.liferay;

public class Product {
    private boolean isExempt;
    private boolean isImported;
    private double price;
    private String name;

    public void setExempt(boolean isExempt) {
        this.isExempt = isExempt;
    }

    public boolean isExempt() {
        return this.isExempt;
    }

    public void setImported(boolean isImported) {
        this.isImported = isImported;
    }

    public boolean isImported() {
        return this.isImported;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
