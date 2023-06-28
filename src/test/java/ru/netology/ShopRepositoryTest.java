package ru.netology;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(17, "футболка", 100);
    Product product2 = new Product(18, "Кепка", 50);

    @Test
    public void testRemoveId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(55);
        });
    }

    @Test
    public void testDeletingAnExistingOneId() {// удаление существующего id
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.remove(17);

        Product[] actual = repo.findAll();
        Product[] expected = {product2};
        Assert.assertArrayEquals(expected, actual);
    }
}
