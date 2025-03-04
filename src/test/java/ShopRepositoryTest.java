import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Laptop", 50000);
        Product product2 = new Product(2, "Phone", 30000);
        Product product3 = new Product(3, "Tablet", 20000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(2);

        Product[] expected = {product1, product3};
        assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void shouldThrowExceptionWhenRemovingNonExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Laptop", 50000);
        Product product2 = new Product(2, "Phone", 30000);

        repo.add(product1);
        repo.add(product2);

        Exception exception = assertThrows(NotFoundException.class, () -> repo.remove(3));

        String expectedMessage = "Element with id: 3 not found";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}

