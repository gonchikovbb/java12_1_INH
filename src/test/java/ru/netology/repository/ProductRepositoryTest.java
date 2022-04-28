package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void shouldFindAll() {
        ProductRepository manager = new ProductRepository();
        Product firstProduct = new Product(1, "firstProduct", 1);
        Product secondProduct = new Product(2, "secondProduct", 2);
        Book firstBook = new Book(3, "firstBook", 3, "Me");
        Book secondBook = new Book(4, "secondBook", 4, "You");
        Smartphone firstSmartphone = new Smartphone(5, "firstSmartphone", 5, "Me");
        Smartphone secondSmartphone = new Smartphone(6, "secondSmartphone", 6, "You");
        manager.save(firstProduct);
        manager.save(secondProduct);
        manager.save(firstBook);
        manager.save(secondBook);
        manager.save(firstSmartphone);
        manager.save(secondSmartphone);
        Product[] expected = new Product[]{firstProduct, secondProduct, firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllOne() {
        ProductRepository manager = new ProductRepository();
        Book secondBook = new Book(4, "secondBook", 4, "You");
        manager.save(secondBook);
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllNull() {
        ProductRepository manager = new ProductRepository();
        Product[] expected = new Product[]{};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        ProductRepository manager = new ProductRepository();
        Product firstProduct = new Product(1, "firstProduct", 1);
        Product secondProduct = new Product(2, "secondProduct", 2);
        Book firstBook = new Book(3, "firstBook", 3, "Me");
        Book secondBook = new Book(4, "secondBook", 4, "You");
        Smartphone firstSmartphone = new Smartphone(5, "firstSmartphone", 5, "Me");
        Smartphone secondSmartphone = new Smartphone(6, "secondSmartphone", 6, "You");
        manager.save(firstProduct);
        manager.save(secondProduct);
        manager.save(firstBook);
        manager.save(secondBook);
        manager.save(firstSmartphone);
        manager.save(secondSmartphone);
        manager.removeById(4);
        Product[] expected = new Product[]{firstProduct, secondProduct, firstBook, firstSmartphone, secondSmartphone};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdOne() {
        ProductRepository manager = new ProductRepository();
        Smartphone firstSmartphone = new Smartphone(5, "firstSmartphone", 5, "Me");
        manager.save(firstSmartphone);
        manager.removeById(5);
        Product[] expected = new Product[]{};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdAll() {
        ProductRepository manager = new ProductRepository();
        Product firstProduct = new Product(1, "firstProduct", 1);
        Product secondProduct = new Product(2, "secondProduct", 2);
        Book firstBook = new Book(3, "firstBook", 3, "Me");
        Book secondBook = new Book(4, "secondBook", 4, "You");
        Smartphone firstSmartphone = new Smartphone(5, "firstSmartphone", 5, "Me");
        Smartphone secondSmartphone = new Smartphone(6, "secondSmartphone", 6, "You");
        manager.save(firstProduct);
        manager.save(secondProduct);
        manager.save(firstBook);
        manager.save(secondBook);
        manager.save(firstSmartphone);
        manager.save(secondSmartphone);
        manager.removeById(1);
        manager.removeById(2);
        manager.removeById(3);
        manager.removeById(4);
        manager.removeById(5);
        manager.removeById(6);
        Product[] expected = new Product[]{};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }
}