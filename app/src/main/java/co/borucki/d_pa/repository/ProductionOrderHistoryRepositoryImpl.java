package co.borucki.d_pa.repository;


import java.util.List;

import co.borucki.d_pa.AndroidApplication;
import co.borucki.d_pa.database.Database;
import co.borucki.d_pa.model.ProductionOrderHistory;

public class ProductionOrderHistoryRepositoryImpl implements ProductionOrderHistoryRepository {
    private final Database mDatabase;
    private static ProductionOrderHistoryRepositoryImpl mInstance;

    private ProductionOrderHistoryRepositoryImpl() {
        mDatabase = AndroidApplication.getDatabase();
    }

    public static ProductionOrderHistoryRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveProductionOrderHistory(List<ProductionOrderHistory> productionOrderHistories) {
        mDatabase.saveProductionOrderHistory(productionOrderHistories);
    }

    @Override
    public void saveProductionOrderHistory(ProductionOrderHistory productionOrderHistory) {
        mDatabase.saveProductionOrderHistory(productionOrderHistory);
    }

    @Override
    public List<ProductionOrderHistory> getAllProductionOrderHistoryByOrderId(String orderId) {
        return mDatabase.getAllProductionOrderHistoryByOrderId(orderId);
    }
}
