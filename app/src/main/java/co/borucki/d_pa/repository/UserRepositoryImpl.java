package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.AndroidApplication;
import co.borucki.d_pa.database.Database;
import co.borucki.d_pa.model.User;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl mInstance = new UserRepositoryImpl();
    private final Database mDatabase;

    private UserRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }


    public static UserRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public List<User> getAllUser() {
        return mDatabase.getAllUser();
    }

    @Override
    public void saveUser(User user) {
        mDatabase.saveUser(user);

    }

    @Override
    public User getUserById(String id) {
        return mDatabase.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        mDatabase.updateUser(user);
    }

    @Override
    public Integer countUsers() {
        return mDatabase.countUsers();
    }
}
