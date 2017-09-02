package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.model.Message;


public interface MessageRepository {
    void saveMessage(Message message);

    void saveMessages(List<Message> messages);

    List<Message> getAllMessages();

    List<Message> getUnreadMessages();

    int getLastIndexOfMessage();

    void updateMessage(Message message);

    Message getMessageById(int messageId);

    void deleteMessage(Message message);
}
