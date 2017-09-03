package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.AndroidApplication;
import co.borucki.d_pa.database.Database;
import co.borucki.d_pa.model.Product;

public class ProductRepositoryImpl implements ProductRepository {
    private static ProductRepositoryImpl mInstance = new ProductRepositoryImpl();
    private final Database mDatabase;

    private ProductRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }


    public static ProductRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveProduct(List<Product> products) {
        mDatabase.saveProduct(products);
    }

    @Override
    public void saveProduct(Product product) {
        mDatabase.saveProduct(product);
    }
}
