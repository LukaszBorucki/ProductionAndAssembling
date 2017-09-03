package co.borucki.d_pa.asyncTask;

import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.d_pa.DTO.ProductionOrderHistoryDTO;
import co.borucki.d_pa.DTO.mappers.Mapper;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.ProductionOrderHistoryRepository;
import co.borucki.d_pa.repository.ProductionOrderHistoryRepositoryImpl;

public class getAllProductionOrderHistory extends AsyncTask<Void, Void, List<ProductionOrderHistoryDTO>> {
    private ProductionOrderHistoryRepository mProductionOrderHistoryRepository = ProductionOrderHistoryRepositoryImpl.getInstance();
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();

    public getAllProductionOrderHistory() {
    }

    @Override
    protected List<ProductionOrderHistoryDTO> doInBackground(Void... params) {
        String link = "http://www.diamon.pl/api/production/getAllProductionOrdersHistory/?DEVICE="
                + mDpaRepository.getDeviceId()
                + "&user="
                + mDpaRepository.getSignedUser()
                + "&pass="
                + mDpaRepository.getSignedUserPassword();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ProductionOrderHistoryDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ProductionOrderHistoryDTO> productionOrderHistoryDTOs) {
        mProductionOrderHistoryRepository
                .saveProductionOrderHistory(Mapper
                        .fromProductOrderHistoryDTOToProductOrderHistory(productionOrderHistoryDTOs));
    }
}
