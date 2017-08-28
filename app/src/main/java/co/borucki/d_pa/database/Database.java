package co.borucki.d_pa.database;

import com.j256.ormlite.stmt.query.In;

import java.util.List;

import co.borucki.d_pa.model.User;

public interface Database {
    List<User> getAllUsers();

    Integer countUsers();

    void saveUser(User user);

    User getUserById( String id);

    void updateUser(User user);
}
