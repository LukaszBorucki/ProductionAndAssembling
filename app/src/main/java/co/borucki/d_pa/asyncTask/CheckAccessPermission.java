package co.borucki.d_pa.asyncTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import co.borucki.d_pa.R;
import co.borucki.d_pa.model.User;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.UserRepository;
import co.borucki.d_pa.repository.UserRepositoryImpl;
import co.borucki.d_pa.secutity.MD5Encryption;
import co.borucki.d_pa.view.MainActivity;


public class CheckAccessPermission extends AsyncTask<String, Void, String> {
    private Context context;
    private Activity activity;
    private String userLogin;
    private String userPassword;
    private UserRepository mUserRepository = UserRepositoryImpl.getInstance();
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();

    public CheckAccessPermission(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        userLogin = params[1];
        userPassword = MD5Encryption.encrypt(params[2]);
        String link = "http://www.diamon.pl/api/check_permission/?DEVICE="
                + params[0]
                + "&user="
                + params[1]
                + "&pass="
                + userPassword;
        StringBuilder builder = new StringBuilder();
        String line;

        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream in = new BufferedInputStream(connection.getInputStream());


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in, "UTF-8"));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }


        return builder.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        if (s.equals("200")) {
            User user = mUserRepository.getUserById(userLogin);
            user.setPassword(userPassword);
            mUserRepository.updateUser(user);
            mDpaRepository.setDefaultUser(userLogin);
            Intent intent = new Intent(context, MainActivity.class);
            activity.startActivity(intent);
            activity.finish();

        } else {
            Toast.makeText(context, R.string.error_signIn, Toast.LENGTH_LONG).show();
        }
    }
}
