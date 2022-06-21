package ru.netology;

public class ProductManager {
    private Repository repository;

    public ProductManager(Repository repository) {  // аргументом(экземпляр) будем использовать класс Repository
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }


    private Product[] products = new Product[0];

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];         // тут будем хранить подошедшие запросу продукты 0 - кол-во элементов
        for (Product product : repository.findAll()) {   // findAll() получение всех элементов, которые будем перебирать
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}

