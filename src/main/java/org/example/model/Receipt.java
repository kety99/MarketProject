package org.example.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class Receipt {
    private final int id;
    private List<Product> products;
    private final String staffName;
    private final LocalDateTime date;
    private double total = 0;

    public Receipt(int id, String staffName, LocalDateTime date, List<Product> products) throws Exception {
        this.id = id;
        this.staffName = staffName;
        this.date = date;
        this.products = products;
        for (Product product : products) {
            total += product.calcPrice();
        }
    }

    public int getId() {
        return id;
    }

    public String getStaffName() {
        return staffName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Receipt: ")
                .append(id)
                .append("\nStaff Name: ")
                .append(staffName)
                .append("\nDate: ")
                .append(date.toString())
                .append("\nItems: ");
        for (Product product: products){
            builder.append(product.getName())
                    .append(" ")
                    .append(product.calcPrice())
                    .append("\n");
        }
        builder.append("\nTotal:")
                .append(total);
        return builder.toString();
    }

    public void receiptToFile()throws IOException {
        File file = new File("Receipt" + id + ".txt");
        if(!file.exists()){
            file.createNewFile();
        }
        PrintWriter out = new PrintWriter(file);
        out.println(this);
        out.close();
    }
}
