package co.borucki.d_pa.view;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.borucki.d_pa.MyDevice;

import co.borucki.d_pa.R;
import co.borucki.d_pa.asyncTask.CheckAccessPermission;
import co.borucki.d_pa.asyncTask.GetAllUsers;
import co.borucki.d_pa.model.User;
import co.borucki.d_pa.repository.DpaRepository;
import co.borucki.d_pa.repository.DpaRepositoryImpl;
import co.borucki.d_pa.repository.UserRepository;
import co.borucki.d_pa.repository.UserRepositoryImpl;
import co.borucki.d_pa.secutity.MD5Encryption;


public class SplashActivity extends AppCompatActivity {
    private DpaRepository mDpaRepository = DpaRepositoryImpl.getInstance();
    private UserRepository mUserRepository = UserRepositoryImpl.getInstance();
    private static final int PERMISSIONS_REQUEST_READ_PHONE_STATUS = 1;
    private List<User> allUsers = new ArrayList<>();
    private Spinner spinner;
    private String spinnerSelectedPos = null;
    private EditText mPassword;
    private Button mLogin;
    private Activity activity = this;
    private String myPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (mDpaRepository.getDeviceId().equals("")) {
            setDeviceId();
        } else {
            if (mUserRepository.countUsers() > 0) {
                loginUser();
            } else {
                GetAllUsers getAllUsers = new GetAllUsers(getApplicationContext(), this);
                getAllUsers.execute(mDpaRepository.getDeviceId());
            }
        }
    }

    private void loginUser() {
        allUsers.addAll(mUserRepository.getAllUsers());
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        for (int i = 0; i < allUsers.size(); i++) {
            User user = allUsers.get(i);
            if (user.getLogin().equals(mDpaRepository.getDefaultUser())) {
                spinnerSelectedPos = user.getName() + " " + user.getSurname();
            }
            spinnerAdapter.insert(user.getName() + " " + user.getSurname(), i);
        }
        spinnerAdapter.notifyDataSetChanged();
        if (spinnerSelectedPos != null) {
            spinner.setSelection(spinnerAdapter.getPosition(spinnerSelectedPos));
        }
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                User user = allUsers.get(spinner.getSelectedItemPosition());
                String login = user.getLogin();
                myPassword = mPassword.getText().toString();
                if (user.getPassword() == null
                        || user.getPassword().equals("")
                        || user.getPassword().equals("password")) {
                    CheckAccessPermission checkAccessPermission = new CheckAccessPermission(getApplicationContext(), activity);
                    checkAccessPermission.execute(mDpaRepository.getDeviceId(), login, myPassword);
                } else {
                    if (user.getPassword().equals(MD5Encryption.encrypt(myPassword))) {
                        mDpaRepository.setDefaultUser(user.getLogin());
                        startMainActivity();
                    } else {
                        Toast.makeText(getApplicationContext(), "Błędne hasło", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void setDeviceId() {
        checkPermission();
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE);
        if (permissionCheck == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            mDpaRepository.setDeviceId(MyDevice.getDeviceID(telephonyManager));
        }
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSIONS_REQUEST_READ_PHONE_STATUS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult);
        switch (requestCode) {
            case PERMISSIONS_REQUEST_READ_PHONE_STATUS:
                if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                    mDpaRepository.setDeviceId(MyDevice.getDeviceID(telephonyManager));
                    GetAllUsers getAllUsers = new GetAllUsers(getApplicationContext(), this);
                    getAllUsers.execute(mDpaRepository.getDeviceId());
                    loginUser();
                } else {
                    showAlertDialogReadStatusPhonePermissionDenied();
                }
        }
    }

    private void showAlertDialogReadStatusPhonePermissionDenied() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Brak zgody na dane urządzenia");
        builder.setMessage("Dostęp do danych urządzenia jest niezbędne do autoryzacji. Brak zgody spowoduje zakończenie aplikacji.");
        builder.setNegativeButton("Zakończ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Wróć do ustawień", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkPermission();
            }
        });
        builder.create().show();
    }
}