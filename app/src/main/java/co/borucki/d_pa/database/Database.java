package co.borucki.d_pa.database;

import com.j256.ormlite.stmt.query.In;

import java.util.List;

import co.borucki.d_pa.model.Message;
import co.borucki.d_pa.model.User;

public interface Database {
    List<User> getAllUsers();

    Integer countUsers();

    void saveUser(User user);

    User getUserById(String id);

    void updateUser(User user);

    void saveMessages(List<Message> messages);

    void saveMessage(Message message);

    List<Message> getAllMessages();

    List<Message> getUnreadMessages();

    int getLastIndexOfMessage();

    void updateMessage(Message message);

    Message getMessageById(int messageId);

    void deleteMessage(Message message);

}
