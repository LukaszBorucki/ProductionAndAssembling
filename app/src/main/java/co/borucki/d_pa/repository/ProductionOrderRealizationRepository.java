package co.borucki.d_pa.repository;


import java.util.List;

import co.borucki.d_pa.model.ProductionOrderRealization;


public interface ProductionOrderRealizationRepository {
    void saveProductionOrderRealization(List<ProductionOrderRealization> productionOrderRealizations);

    void saveProductionOrderRealization(ProductionOrderRealization productionOrderRealization);

    List<ProductionOrderRealization> getProductionOrderRealizationByOrderId(String orderId);

}
