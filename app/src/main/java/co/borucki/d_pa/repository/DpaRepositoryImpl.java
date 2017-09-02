package co.borucki.d_pa.repository;

import co.borucki.d_pa.AndroidApplication;
import co.borucki.d_pa.persistence.DpaSharedPreferences;

public class DpaRepositoryImpl implements DpaRepository {
    private static DpaRepositoryImpl mInstance = new DpaRepositoryImpl();
    private final DpaSharedPreferences mSharedPreferences;

    public static DpaRepositoryImpl getInstance() {
        return mInstance;
    }

    private DpaRepositoryImpl() {
        mSharedPreferences = AndroidApplication.getSharedPreferences();
    }

    @Override
    public String getDeviceId() {
        return mSharedPreferences.getDeviceId();
    }

    @Override
    public void setDeviceId(String deviceId) {
        mSharedPreferences.setDeviceId(deviceId);
    }

    @Override
    public String getDefaultUser() {
        return mSharedPreferences.getDefaultUser();
    }

    @Override
    public void setDefaultUser(String user) {
        mSharedPreferences.setDefaultUser(user);
    }

    @Override
    public void setSignedUser(String user) {
        mSharedPreferences.setSignedUser(user);
    }

    @Override
    public String getSignedUser() {
        return mSharedPreferences.getSignedUser();
    }

    @Override
    public void setSignedUserPassword(String password) {
        mSharedPreferences.setSignedUserPassword(password);
    }

    @Override
    public String getSignedUserPassword() {
        return mSharedPreferences.getSignedUserPassword();
    }

    @Override
    public int getLastMessageIndex() {
        return mSharedPreferences.getLastMessageIndex();
    }

    @Override
    public void setLastMessageIndex(int index) {
        mSharedPreferences.setLastMessageIndex(index);
    }
}
