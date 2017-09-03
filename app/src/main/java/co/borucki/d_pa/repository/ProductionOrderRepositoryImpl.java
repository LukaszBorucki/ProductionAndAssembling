package co.borucki.d_pa.repository;


import java.util.List;

import co.borucki.d_pa.AndroidApplication;
import co.borucki.d_pa.database.Database;
import co.borucki.d_pa.model.ProductionOrder;

public class ProductionOrderRepositoryImpl implements ProductionOrderRepository {
    private final Database mDatabase;
    private static ProductionOrderRepositoryImpl mInstance= new ProductionOrderRepositoryImpl();

    private ProductionOrderRepositoryImpl() {
        mDatabase = AndroidApplication.getDatabase();
    }

    public static ProductionOrderRepositoryImpl getInstance(){
        return mInstance;
    }

    @Override
    public void saveProductionOrder(List<ProductionOrder> productionOrders) {
        mDatabase.saveProductionOrder(productionOrders);
    }

    @Override
    public void saveProductionOrder(ProductionOrder productionOrder) {
        mDatabase.saveProductionOrder(productionOrder);
    }

    @Override
    public List<ProductionOrder> getAllProductionOrder() {
        return mDatabase.getAllProductionOrder();
    }

    @Override
    public List<ProductionOrder> getProductionOrderByStatus(String status) {
        return mDatabase.getProductionOrderByStatus(status);
    }

    @Override
    public ProductionOrder getProductionOrderByOrderId(String id) {
        return mDatabase.getProductionOrderByOrderId(id);
    }
}
