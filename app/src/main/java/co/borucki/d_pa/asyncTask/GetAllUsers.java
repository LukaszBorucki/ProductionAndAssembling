package co.borucki.d_pa.asyncTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.borucki.d_pa.DTO.UserDTO;
import co.borucki.d_pa.DTO.mappers.Mapper;
import co.borucki.d_pa.model.User;
import co.borucki.d_pa.repository.UserRepository;
import co.borucki.d_pa.repository.UserRepositoryImpl;
import co.borucki.d_pa.view.SplashActivity;


public class GetAllUsers extends AsyncTask<String, Void, List<UserDTO>> {
    private Context context;
    private Activity activity;

    public GetAllUsers(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    private UserRepository mUserRepository = UserRepositoryImpl.getInstance();

    @Override
    protected List<UserDTO> doInBackground(String... params) {

        String link = "http://www.diamon.pl/api/device_permission/?DEVICE=" + params[0];
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, UserDTO[].class));
    }

    @Override
    protected void onPostExecute(List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();
        userList.addAll(Mapper.fromUserDTOListToUserList(userDTOList));
        for (User user : userList) {
            mUserRepository.saveUser(user);
        }
        Intent intent = new Intent(context, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        activity.finish();
    }
}
