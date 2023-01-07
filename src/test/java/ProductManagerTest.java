import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void testWhenFewProductsFinded() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 200, "Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "Tolstoy");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = { book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveProduct() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 200, "Rowling");
        Book book3 = new Book(3, "War and Peace", 300, "Tolstoy");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = { book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenFewProductsFindedPhone() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Smartphone smartphone1 = new Smartphone(1, "iPhone 10", 100, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "iPhone 11", 200, "Apple");
        Smartphone smartphone3 = new Smartphone(3, "iPhone 12", 300, "Apple");


        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = { smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
       
    }
    
    @Test
    public void testModel() {
        String hp1 = "Harry Potter 1";
        String author = "Rowling";
        int price = 100;
        Book book1 = new Book(1, hp1, price, author);
        Assertions.assertEquals(book1.getName(), hp1);
        Assertions.assertEquals(book1.getPrice(), price);
        Assertions.assertEquals(book1.getAuthor(), author);
        String apple = "Apple";
        Smartphone smartphone1 = new Smartphone(1, "iPhone 10", price, apple);
        Assertions.assertEquals(smartphone1.getVendor(), apple);
        Assertions.assertEquals(smartphone1.getId(), 1);
    }
}
