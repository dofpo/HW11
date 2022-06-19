package ru.netology;

public class Repository {
    private Product[] products = new Product[0];

    public void add(Product product) {  // метод сохранения (добавления) продукта
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    public Product[] findAll() {
        return products;
    }
}