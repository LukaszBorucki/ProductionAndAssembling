package co.borucki.d_pa.DTO;

public class UserDTO {
    private String login;
    private String name;
    private String surname;
    private String assembling;
    private String id;
    private String orderAssembling;
    private String active;
    private String level;
    private String turned;

    public UserDTO() {
    }

    public UserDTO(String login, String name, String surname, String assembling, String id, String orderAssembling, String active, String level, String turned) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.assembling = assembling;
        this.id = id;
        this.orderAssembling = orderAssembling;
        this.active = active;
        this.level = level;
        this.turned = turned;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAssembling() {
        return assembling;
    }

    public void setAssembling(String assembling) {
        this.assembling = assembling;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderAssembling() {
        return orderAssembling;
    }

    public void setOrderAssembling(String orderAssembling) {
        this.orderAssembling = orderAssembling;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTurned() {
        return turned;
    }

    public void setTurned(String turned) {
        this.turned = turned;
    }
}

