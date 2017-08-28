package co.borucki.d_pa.persistence;

import android.content.Context;
import android.content.SharedPreferences;

public class DpaSharedPreferences {
    private static final String DPA_SHARED_PREFERENCE = "DPA Shared Preference";
    private static final String DEVICE_ID = "IMEI";
    private static final String DEFAULT_USER = "default user";
    private final SharedPreferences mSharedPreferences;

    public DpaSharedPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(DPA_SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    public String getDeviceId() {
        return mSharedPreferences.getString(DEVICE_ID, "");
    }

    public void setDeviceId(String deviceId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(DEVICE_ID, deviceId);
        editor.apply();
    }

    public String getDefaultUser() {
        return mSharedPreferences.getString(DEFAULT_USER,"");
    }

    public void setDefaultUser(String user) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(DEFAULT_USER,user);
        editor.apply();
    }


}
