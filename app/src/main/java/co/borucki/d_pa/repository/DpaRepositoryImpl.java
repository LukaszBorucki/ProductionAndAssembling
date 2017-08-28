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


}
