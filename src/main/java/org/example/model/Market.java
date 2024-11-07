package org.example.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Market {
    private final String id;
    private String name;
    private final List<Product> productsFoods;
    private final List<Product> productsGoods;
    private double markUpFood;
    private double markupGoods;
    private final Set<Receipt> receipts;
    private final double percentOff;
    private final int daysTillExp;
    private int currentId = 0;
    private double totalIncome = 0;

    public Market(String id, String name, double markUpFood, double markupGoods, double percentOff, int daysTillExp) {
        this.id = id;
        this.name = name;
        this.markUpFood = markUpFood;
        this.markupGoods = markupGoods;
        this.percentOff = percentOff;
        this.daysTillExp = daysTillExp;
        this.productsFoods = new LinkedList<>();
        this.productsGoods = new LinkedList<>();
        this.receipts = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarkUpFood() {
        return markUpFood;
    }

    public double getMarkupGoods() {
        return markupGoods;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarkUpFood(double markUpFood) {
        this.markUpFood = markUpFood;
    }

    public void setMarkupGoods(double markupGoods) {
        this.markupGoods = markupGoods;
    }

    public double getPercentOff() {
        return percentOff;
    }

    public int getDaysTillExp() {
        return daysTillExp;
    }

    public int getReceiptId() {
        return ++currentId;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public List<Product> getProductQuantity(Category category, String name, int quantity) throws Exception {
        List<Product> products;
        if (category.equals(Category.FOOD)) {
            products = productsFoods;
        } else {
            products = productsGoods;
        }
        List<Product> selectedProducts = new LinkedList<>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                selectedProducts.add(product);
                if (selectedProducts.size() == quantity) {
                    products.removeAll(selectedProducts);
                    return selectedProducts;
                }
            }
        }
        throw new Exception("Not enough" + name + ". " + (quantity - selectedProducts.size()) + "more needed.");
    }

    public int currentReceiptCount(){
        return currentId;
    }

    public void addingToTotalIncome(double total){
        totalIncome += total;
    }

    public void addProduct(Product product){
        if(product.getCategory().equals(Category.FOOD)){
            productsFoods.add(product);
        }else{
            productsGoods.add(product);
        }
    }

}
