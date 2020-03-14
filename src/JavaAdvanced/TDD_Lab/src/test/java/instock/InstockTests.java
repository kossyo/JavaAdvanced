package instock;

//import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InstockTests {

    private final String DEFAULT_LABEL_NAME = "Label";
    private final int DEFAULT_QUANTITY = 200;
    private Product product;
    private Instock stock;

    @Before
    public void setUp() {
        this.product = new Product(DEFAULT_LABEL_NAME, 2.5, DEFAULT_QUANTITY);
        this.stock = new Instock();
    }

    @Test
    public void shouldAddProduct() {

        stock.add(product);

        assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldHaveNonZeroCountAfterAddProduct() {

        stock.add(product);

        int expected = 1;
        int actual = this.stock.getCount();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountEqualsToProductsAdded() {

        stock.add(product);
        stock.add(product);
        stock.add(product);

        int expected = 3;
        int actual = this.stock.getCount();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseIfProductNotPresent() {


        assertFalse(this.stock.contains(product));
    }

    @Test
    public void shouldReturnTrueIfProductLabelsMatch() {

        Product product2 = new Product(DEFAULT_LABEL_NAME, 10, 10);

        this.stock.add(product2);
        assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldReturnCorrectProductByInsertionOrderWhenSingleProduct() {

        this.stock.add(product);

        Product actual = this.stock.find(1);

        assertEquals(product, actual);
    }

    @Test
    public void shouldReturnCorrectProductByInsertionOrderWhenMultipleProducts() {

        Product product2 = new Product(DEFAULT_LABEL_NAME + "2", 10, 10);
        Product product3 = new Product(DEFAULT_LABEL_NAME + "3", 10, 10);

        this.stock.add(product3);
        this.stock.add(product);
        this.stock.add(product2);

        Product actual = this.stock.find(3);

        assertEquals(product2, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenFindInvokedWithInvalidIndex() {

        this.stock.add(product);

        this.stock.find(2);

        //assertEquals(product, actual);
    }

    @Test
    public void shouldAddQuantityToExistingProductSingleTime() {

        this.stock.add(product);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_QUANTITY);

        int actual = this.stock.find(1).getQuantity();

        assertEquals(2 * DEFAULT_QUANTITY, actual);
    }

    @Test
    public void shouldAddQuantityToExistingProductMultipleTimes() {

        this.stock.add(product);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_QUANTITY);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_QUANTITY);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_QUANTITY);

        int actual = this.stock.find(1).getQuantity();

        assertEquals(4 * DEFAULT_QUANTITY, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowExceptionIfProductNotPresent() {

        this.stock.changeQuantity(product.getLabel(), DEFAULT_QUANTITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowExceptionIfProductNotPresent() {

        this.stock.findByLabel(DEFAULT_LABEL_NAME);
    }

    @Test
    public void findByLabelShouldReturnCorrectProduct() {

        this.stock.add(product);

        Product actual = this.stock.findByLabel(product.getLabel());

        assertEquals(product, actual);

    }

    @Test
    public void findByLabelShouldReturnCorrectProductWhenMultipleProductsAdded() {

        Product product2 = new Product(DEFAULT_LABEL_NAME + "2", 10,10);
        Product product3 = new Product(DEFAULT_LABEL_NAME + "3", 10,10);
        Product product4 = new Product(DEFAULT_LABEL_NAME + "4", 10,10);

        this.stock.add(product);
        this.stock.add(product2);
        this.stock.add(product3);
        this.stock.add(product4);

        Product actual = this.stock.findByLabel(DEFAULT_LABEL_NAME + "3");

        assertEquals(product3, actual);
    }

    @Test
    public void shouldReturnFirstNProductsSortedByLabel() {

        Product product2 = new Product(DEFAULT_LABEL_NAME + "2", 1, 1);
        Product product3 = new Product(DEFAULT_LABEL_NAME + "3", 1, 1);
        Product product4 = new Product(DEFAULT_LABEL_NAME + "4", 1, 1);

        this.stock.add(product);
        this.stock.add(product2);
        this.stock.add(product3);
        this.stock.add(product4);

        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(0);

        assertFalse(actual.iterator().hasNext());

    }

}
