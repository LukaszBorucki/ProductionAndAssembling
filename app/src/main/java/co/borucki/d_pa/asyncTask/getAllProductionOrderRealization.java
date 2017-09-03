package co.borucki.d_pa.asyncTask;


import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.d_pa.DTO.ProductionOrderRealizationDTO;
import co.borucki.d_pa.DTO.mappers.Mapper;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.ProductionOrderRealizationRepository;
import co.borucki.d_pa.repository.ProductionOrderRealizationRepositoryImpl;

public class getAllProductionOrderRealization extends AsyncTask<Void, Void, List<ProductionOrderRealizationDTO>> {
    private ProductionOrderRealizationRepository mProductionOrderRealizationRepository
            = ProductionOrderRealizationRepositoryImpl.getInstance();
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();

    public getAllProductionOrderRealization() {
    }

    @Override
    protected List<ProductionOrderRealizationDTO> doInBackground(Void... params) {
        String link = "http://www.diamon.pl/api/production/getAllProductionOrdersRealization/?DEVICE="
                + mDpaRepository.getDeviceId()
                + "&user="
                + mDpaRepository.getSignedUser()
                + "&pass="
                + mDpaRepository.getSignedUserPassword();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ProductionOrderRealizationDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ProductionOrderRealizationDTO> productionOrderRealizationDTOs) {
        mProductionOrderRealizationRepository
                .saveProductionOrderRealization(Mapper.fromProductOrderRealizationDTOToProductOrderRealization(productionOrderRealizationDTOs));
    }
}
