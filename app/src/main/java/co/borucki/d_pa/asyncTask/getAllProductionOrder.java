package co.borucki.d_pa.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.d_pa.DTO.ProductionOrderDTO;
import co.borucki.d_pa.DTO.mappers.Mapper;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.ProductionOrderRepository;
import co.borucki.d_pa.repository.ProductionOrderRepositoryImpl;

public class getAllProductionOrder extends AsyncTask<Void, Void, List<ProductionOrderDTO>> {
    private ProductionOrderRepository mProductionOrderRepository = ProductionOrderRepositoryImpl.getInstance();
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();

    public getAllProductionOrder() {
    }

    @Override
    protected List<ProductionOrderDTO> doInBackground(Void... params) {
        String link = "http://www.diamon.pl/api/production/getAllProductionOrders/?DEVICE="
                + mDpaRepository.getDeviceId()
                + "&user="
                + mDpaRepository.getSignedUser()
                + "&pass="
                + mDpaRepository.getSignedUserPassword();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ProductionOrderDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ProductionOrderDTO> productionOrderDTOs) {
        mProductionOrderRepository.saveProductionOrder(Mapper.fromProductionOrderDTOToProductionOrder(productionOrderDTOs));
    }
}
