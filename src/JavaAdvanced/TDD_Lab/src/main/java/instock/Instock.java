package instock;//import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Instock implements ProductStock {

    private List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        //throw new UnsupportedOperationException();
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {

        return this.products.contains(product);
//
//        Optional<Product> optionalProduct =
//                this.products.stream().filter(p -> product.getLabel().equals(p.getLabel())).findFirst();
//
//        return optionalProduct.isPresent();
    }

    @Override
    public void add(Product product) {

        this.products.add(product);
    }

    @Override
    public void changeQuantity(String productName, int quantity) {

        //this.products.get(0).setQuantity(quantity);
        Product product = this.products
                .stream()
                .filter(product1 -> productName.equals(product1.getLabel()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        product.setQuantity(product.getQuantity() + quantity);


    }

    @Override
    public Product find(int index) {
        return this.products.get(index - 1);
    }

    @Override
    public Product findByLabel(String label) {

        return this.products
                .stream()
                .filter(product -> label.equals(product.getLabel()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        return new ArrayList<>();
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }
}
