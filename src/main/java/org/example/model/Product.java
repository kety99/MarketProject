package org.example.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Product {
    private final String id;
    private final String name;
    private final double wholeSalePrice;
    private final LocalDate expirationDate;
    private final Category category;
    private final Market market;

    public Product(String id, String name, double wholeSalePrice, LocalDate expirationDate, Category category, Market market) {
        this.id = id;
        this.name = name;
        this.wholeSalePrice = wholeSalePrice;
        this.expirationDate = expirationDate;
        this.category = category;
        this.market = market;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWholeSalePrice() {
        return wholeSalePrice;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public Category getCategory() {
        return category;
    }

    public double calcPrice()throws RuntimeException{
        double finalPrice = 0;
        if(LocalDate.now().isAfter(expirationDate)){
            throw new RuntimeException("Expired product!");
        }
        if(category.equals(Category.FOOD)) {
            finalPrice = wholeSalePrice + (wholeSalePrice * market.getMarkUpFood() / 100);
        }else{
            finalPrice = wholeSalePrice + (wholeSalePrice * market.getMarkupGoods() / 100);
        }

        if(market.getDaysTillExp()>= ChronoUnit.DAYS.between(LocalDate.now(), expirationDate)){
            finalPrice -= (finalPrice * market.getPercentOff() / 100);
        }

        return finalPrice;
    }
}
