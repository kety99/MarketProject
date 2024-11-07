package org.example;

import org.example.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Market market = new Market("21sd312", "KapersiMarket", 4, 3, 50, 5);
        Product product = new Product("jash4sd", "Lutenica", 3, LocalDate.now().plusDays(4906), Category.FOOD, market);
        market.addProduct(product);
        Staff staff = new Staff("der4354", "Preslav", 12000, 1);
        CashDask cashDask = new CashDask(staff, market);
        cashDask.addProducts(product);
        try {
            Receipt receipt = cashDask.bought(34000);
            System.out.println(receipt);
            receipt.receiptToFile();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}