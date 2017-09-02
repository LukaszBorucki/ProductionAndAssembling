package co.borucki.d_pa.repository;

public interface DpaRepository {
    String getDeviceId();

    void setDeviceId(String deviceId);

    String getDefaultUser();

    void setDefaultUser(String user);

    void setSignedUser(String user);

    String getSignedUser();

    void setSignedUserPassword(String password);

    String getSignedUserPassword();
    int getLastMessageIndex();
    void setLastMessageIndex(int index);
}
