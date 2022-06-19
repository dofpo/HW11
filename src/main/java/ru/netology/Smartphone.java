package ru.netology;

public class Smartphone extends Product {
    private String fabricator;

    public Smartphone(int id, String name, int cost, String fabricator) {
        super(id, name, cost);
        this.fabricator=fabricator;
    }
}
