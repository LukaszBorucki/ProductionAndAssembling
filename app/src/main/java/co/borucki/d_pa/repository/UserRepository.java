package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.model.User;

public interface UserRepository {
    List<User> getAllUser();

    void saveUser(User user);

    Integer countUsers();

    User getUserById(String id);

    void  updateUser(User user);
}
