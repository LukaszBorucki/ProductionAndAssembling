package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.model.ProductionOrder;



public interface ProductionOrderRepository {
    void saveProductionOrder(List<ProductionOrder> productionOrders);

    void saveProductionOrder(ProductionOrder productionOrder);

    List<ProductionOrder> getAllProductionOrder();

    List<ProductionOrder> getProductionOrderByStatus(String status);

    ProductionOrder getProductionOrderByOrderId(String id);
}
