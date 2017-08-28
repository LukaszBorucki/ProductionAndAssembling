package co.borucki.d_pa.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "user")
public class User {
    @DatabaseField(columnName = "login", id = true)
    private String login;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "surname")
    private String surname;
    @DatabaseField(columnName = "assembling")
    private String assembling;
    @DatabaseField(columnName = "id")
    private String id;
    @DatabaseField(columnName = "orderAssembling")
    private String orderAssembling;
    @DatabaseField(columnName = "active")
    private String active;
    @DatabaseField(columnName = "level")
    private String level;
    @DatabaseField(columnName = "turned")
    private String turned;
    @DatabaseField(columnName = "password")
    private String password;

    public User() {
    }



    public User( String login, String name, String surname, String assembling, String id, String orderAssembling, String active, String level, String turned, String password) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

