package co.borucki.d_pa.repository;

public interface DpaRepository {
    String getDeviceId();

    void setDeviceId(String deviceId);

    String getDefaultUser();

    void setDefaultUser(String user);


}
