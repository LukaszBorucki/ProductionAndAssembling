package co.borucki.d_pa.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "messages")
public class Message {
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "date")
    private String date;
    @DatabaseField(columnName = "userId")
    private String userId;
    @DatabaseField(columnName = "contents")
    private String contents;
    @DatabaseField(columnName = "isRead")
    private boolean isRead;

    public Message() {

    }

    public Message(int id, String date, String userId, String contents, boolean isRead) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.contents = contents;
        this.isRead = isRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
