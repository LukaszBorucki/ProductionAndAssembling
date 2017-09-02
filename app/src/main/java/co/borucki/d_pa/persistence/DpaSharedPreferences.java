package co.borucki.d_pa.persistence;

import android.content.Context;
import android.content.SharedPreferences;

public class DpaSharedPreferences {
    private static final String DPA_SHARED_PREFERENCE = "DPA Shared Preference";
    private static final String DEVICE_ID = "IMEI";
    private static final String DEFAULT_USER = "default user";
    private static final String SIGNED_USER = "signed user name";
    private static final String SIGNED_USER_PASSWORD = "signed user password";
    private static final String LAST_MESSAGE_INDEX = "last message index";
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
        return mSharedPreferences.getString(DEFAULT_USER, "");
    }

    public void setDefaultUser(String user) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(DEFAULT_USER, user);
        editor.apply();
    }


    public void setSignedUser(String user) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SIGNED_USER, user);
        editor.apply();
    }

    public String getSignedUser() {
        return mSharedPreferences.getString(SIGNED_USER, "N/A");
    }

    public void setSignedUserPassword(String password) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SIGNED_USER_PASSWORD, password);
        editor.apply();
    }

    public String getSignedUserPassword() {
        return mSharedPreferences.getString(SIGNED_USER_PASSWORD, "N/A");
    }

    public int getLastMessageIndex() {
        return mSharedPreferences.getInt(LAST_MESSAGE_INDEX, 0);
    }

    public void setLastMessageIndex(int index) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(LAST_MESSAGE_INDEX, index);
        editor.apply();
    }
}
