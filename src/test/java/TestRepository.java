package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestRepository {
    private Repository repo = new Repository();
    private Book book = new Book(1,"Voina i mir",500,"Л.Н. Толстой");
    private Book book1 = new Book(2,"Pro Fedota streltsa, udalogo molodtsa",650,"Л.Филатов");

    private Smartphone tel = new Smartphone(3,"13 Pro",500,"IPhone");
    private Smartphone tel1 = new Smartphone(4,"Mi 11",500,"Xiaomi");

    @BeforeEach
    public void setUp() {


        repo.add(book);
        repo.add(tel);
    }
    @Test
    public void SaveProducts() {
        repo.add(book1);
        Product[] actual = repo.findAll();
        Product[] expected = {book, tel, book1};
        Assertions.assertArrayEquals(expected, actual);
    }
}
