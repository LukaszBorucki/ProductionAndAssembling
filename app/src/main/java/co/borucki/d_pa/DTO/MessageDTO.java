package co.borucki.d_pa.DTO;

public class MessageDTO {
    private int id;
    private String date;
    private String userId;
    private String contents;
    private int isRead;

    public MessageDTO() {

    }

    public MessageDTO(int id, String date, String userId, String contents, int isRead) {
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

    public int isRead() {
        return isRead;
    }

    public void setRead(int read) {
        isRead = read;
    }
}
