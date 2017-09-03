package co.borucki.d_pa.repository;


import java.util.List;

import co.borucki.d_pa.model.ProductionOrderHistory;

public interface ProductionOrderHistoryRepository {
    void saveProductionOrderHistory(List<ProductionOrderHistory> productionOrderHistories);

    void saveProductionOrderHistory(ProductionOrderHistory productionOrderHistory);

    List<ProductionOrderHistory> getAllProductionOrderHistoryByOrderId(String orderId);
}
