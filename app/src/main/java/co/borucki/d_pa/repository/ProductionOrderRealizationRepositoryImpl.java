package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.AndroidApplication;
import co.borucki.d_pa.database.Database;
import co.borucki.d_pa.model.ProductionOrderRealization;

public class ProductionOrderRealizationRepositoryImpl implements ProductionOrderRealizationRepository{
    private final Database mDatabase;
    public static ProductionOrderRealizationRepository mInstance = new ProductionOrderRealizationRepositoryImpl();
    private ProductionOrderRealizationRepositoryImpl() {
    mDatabase= AndroidApplication.getDatabase();
    }
    public static ProductionOrderRealizationRepository getInstance(){
        return mInstance;
    }

    @Override
    public void saveProductionOrderRealization(List<ProductionOrderRealization> productionOrderRealizations) {
        mDatabase.saveProductionOrderRealization(productionOrderRealizations);
    }

    @Override
    public void saveProductionOrderRealization(ProductionOrderRealization productionOrderRealization) {
        mDatabase.saveProductionOrderRealization(productionOrderRealization);
    }

    @Override
    public List<ProductionOrderRealization> getProductionOrderRealizationByOrderId(String orderId) {
        return mDatabase.getProductionOrderRealizationByOrderId(orderId);
    }
}
