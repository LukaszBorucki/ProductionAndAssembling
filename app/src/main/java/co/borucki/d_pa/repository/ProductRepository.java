package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.model.Product;

public interface ProductRepository {
    void saveProduct(List<Product> products);

    void saveProduct(Product product);
}
