package co.borucki.d_pa.asyncTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.borucki.d_pa.DTO.ProductDTO;
import co.borucki.d_pa.DTO.UserDTO;
import co.borucki.d_pa.DTO.mappers.Mapper;
import co.borucki.d_pa.model.Product;
import co.borucki.d_pa.model.User;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.ProductRepository;
import co.borucki.d_pa.repository.ProductRepositoryImpl;
import co.borucki.d_pa.repository.UserRepository;
import co.borucki.d_pa.repository.UserRepositoryImpl;
import co.borucki.d_pa.view.SplashActivity;


public class GetAllProduct extends AsyncTask<String, Void, List<ProductDTO>> {
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();
    private ProductRepository mProductRepository = ProductRepositoryImpl.getInstance();
    private Context context;
    private Activity activity;

    public GetAllProduct(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected List<ProductDTO> doInBackground(String... params) {

        String link = "http://www.diamon.pl/api/getAllProducts/?DEVICE="
                + mDpaRepository.getDeviceId()
                + "&user="
                + mDpaRepository.getSignedUser()
                + "&pass="
                + mDpaRepository.getSignedUserPassword();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ProductDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ProductDTO> productDTOList) {
        List<Product> userList = new ArrayList<>();
        userList.addAll(Mapper.fromProoductDTOToProduct(productDTOList));

//            mUserRepository.saveUser(user);

//        Intent intent = new Intent(context, SplashActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//        activity.finish();
    }
}
