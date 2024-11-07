package org.example.model;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CashDask {
    private Staff staff;
    private List<Product> scannedProducts;
    private Market market;

    public CashDask(Staff staff, Market market) {
        this.staff = staff;
        this.market = market;
        this.scannedProducts = new LinkedList<>();
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void addProducts(Product product){
        scannedProducts.add(product);
    }

    public Receipt bought(double clientMoney) throws Exception{
        Receipt currentReceipt = new Receipt(market.getReceiptId(), staff.getName(), LocalDateTime.now(), scannedProducts);
        if(clientMoney >=  currentReceipt.getTotal()){
            return currentReceipt;
        } else {
            return null;
        }
    }
}
