package org.example.model;

public class Staff {
    private String id;
    private String name;
    private double salary;
    private int cashDesk;

    public Staff(String id, String name, double salary, int cashDesk) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.cashDesk = cashDesk;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getCashDesk() {
        return cashDesk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCashDesk(int cashDesk) {
        this.cashDesk = cashDesk;
    }
}
