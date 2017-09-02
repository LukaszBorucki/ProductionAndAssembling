package co.borucki.d_pa.repository;

import java.util.List;

import co.borucki.d_pa.AndroidApplication;
import co.borucki.d_pa.database.Database;
import co.borucki.d_pa.model.Message;


public class MessageRepositoryImpl implements MessageRepository {
    private static MessageRepositoryImpl mInstance = new MessageRepositoryImpl();
    private final Database mDatabase;

    private MessageRepositoryImpl() {

        mDatabase = AndroidApplication.getDatabase();
    }


    public static MessageRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public void saveMessage(Message message) {
        mDatabase.saveMessage(message);
    }

    @Override
    public void saveMessages(List<Message> messages) {
        mDatabase.saveMessages(messages);
    }

    @Override
    public List<Message> getAllMessages() {
        return mDatabase.getAllMessages();
    }

    @Override
    public List<Message> getUnreadMessages() {
        return mDatabase.getUnreadMessages();
    }

    @Override
    public int getLastIndexOfMessage() {
        return mDatabase.getLastIndexOfMessage();
    }

    @Override
    public void updateMessage(Message message) {
        mDatabase.updateMessage(message);
    }

    @Override
    public Message getMessageById(int messageId) {
        return mDatabase.getMessageById(messageId);
    }

    @Override
    public void deleteMessage(Message message) {
        mDatabase.deleteMessage(message);
    }
}
