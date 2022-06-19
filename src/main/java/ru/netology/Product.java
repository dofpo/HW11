package ru.netology;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
public class Product {
    protected int id;
    protected String name;
    protected int cost;


    public String getName() {
        return name;
    }

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
