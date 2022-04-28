package ru.netology.manager;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {


    @Test
    public void shouldReturnName() {
        Product firstProduct = new Product(1, "firstProduct", 1);
        Product secondProduct = new Product(2, "secondProduct", 2);
        Book firstBook = new Book(3, "firstBook", 3, "Me");
        Book secondBook = new Book(4, "secondBook", 4, "You");
        Smartphone firstSmartphone = new Smartphone(5, "firstSmartphone", 5, "Me");
        Smartphone secondSmartphone = new Smartphone(6, "secondSmartphone", 6, "You");
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(firstProduct);
        manager.add(secondProduct);
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        Product[] expected = {firstBook};
        Product[] actual = manager.searchBy("firstBook");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneName() {
        Book firstBook = new Book(3, "firstBook", 3, "Me");
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(firstBook);
        Product[] expected = {firstBook};
        Product[] actual = manager.searchBy("firstBook");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnByText() {
        Product firstProduct = new Product(1, "firstProduct", 1);
        Product secondProduct = new Product(2, "secondProduct", 2);
        Book firstBook = new Book(3, "firstBook", 3, "Me");
        Book secondBook = new Book(4, "secondBook", 4, "You");
        Smartphone firstSmartphone = new Smartphone(5, "firstSmartphone", 5, "Me");
        Smartphone secondSmartphone = new Smartphone(6, "secondSmartphone", 6, "You");
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(firstProduct);
        manager.add(secondProduct);
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        Product[] expected = {firstBook, firstSmartphone};
        Product[] actual = manager.searchBy("Me");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNot() {
        Product firstProduct = new Product(1, "firstProduct", 1);
        Product secondProduct = new Product(2, "secondProduct", 2);
        Book firstBook = new Book(3, "firstBook", 3, "Me");
        Book secondBook = new Book(4, "secondBook", 4, "You");
        Smartphone firstSmartphone = new Smartphone(5, "firstSmartphone", 5, "Me");
        Smartphone secondSmartphone = new Smartphone(6, "secondSmartphone", 6, "You");
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(firstProduct);
        manager.add(secondProduct);
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        Product[] expected = {};
        Product[] actual = manager.searchBy("Me123");
        assertArrayEquals(expected, actual);
    }
}
