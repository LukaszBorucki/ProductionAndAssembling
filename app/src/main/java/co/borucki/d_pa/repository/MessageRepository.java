package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.model.Message;


public interface MessageRepository {
    void saveMessage(Message message);

    void saveMessage(List<Message> messages);

    List<Message> getAllMessage();

    List<Message> getUnreadMessage();

    int getLastIndexOfMessage();

    void updateMessage(Message message);

    Message getMessageById(int messageId);

    void deleteMessage(Message message);
}
