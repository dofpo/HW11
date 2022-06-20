package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProductManager {
    private Repository repo = new Repository();
    private ProductManager manager = new ProductManager(repo);

    private Book book = new Book(1,"Voina i mir",500,"Л.Н. Толстой");
    private Book book1 = new Book(2,"Pro Fedota streltsa, udalogo molodtsa",650,"Л.Филатов");

    private Smartphone tel = new Smartphone(3,"13 Pro",500,"IPhone");
    private Smartphone tel1 = new Smartphone(4,"Mi 11",500,"Xiaomi");

    @BeforeEach
    public void setUp() {
        manager.add(book);
        manager.add(book1);
        manager.add(tel);
        manager.add(tel1);
    }
    @Test
    public void AddProduct() {
        manager.add(book);
        Product[] actual = repo.findAll();
        Product[] expected = {book, book1, tel, tel1, book};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void SearchProductByName() {
        Product[] actual = manager.searchBy("Voina i mir");
        Product[] expected = {book};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void SearchOneByTextInName() {
        Product[] actual = manager.searchBy("Fed");
        Product[] expected = {book1};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void FindNoProduct() {
        Product[] actual = manager.searchBy("нет");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindSeveralProducts() {
        Product[] actual = manager.searchBy("Pr");
        Product[] expected = {book1, tel};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void RemoveById() {
        manager.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, tel, tel1};
        Assertions.assertArrayEquals(expected, actual);
    }

}
