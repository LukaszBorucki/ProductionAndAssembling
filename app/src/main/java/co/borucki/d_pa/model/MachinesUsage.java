package co.borucki.d_pa.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "machinesUsage")
public class MachinesUsage {
    @DatabaseField(columnName = "id", index = true)
    private int id;
    @DatabaseField(columnName = "machinesId")
    private String machinesId;
    @DatabaseField(columnName = "date")
    private String date;
    @DatabaseField(columnName = "startDateTime")
    private String startDateTime;
    @DatabaseField(columnName = "stopDateTime")
    private String stopDateTime;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "employee")
    private String employee;
    @DatabaseField(columnName = "orderId")
    private String orderId;

    public MachinesUsage() {
    }

    public MachinesUsage(int id, String machinesId, String date, String startDateTime, String stopDateTime, int status, String employee, String orderId) {
        this.id = id;
        this.machinesId = machinesId;
        this.date = date;
        this.startDateTime = startDateTime;
        this.stopDateTime = stopDateTime;
        this.status = status;
        this.employee = employee;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMachinesId() {
        return machinesId;
    }

    public void setMachinesId(String machinesId) {
        this.machinesId = machinesId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getStopDateTime() {
        return stopDateTime;
    }

    public void setStopDateTime(String stopDateTime) {
        this.stopDateTime = stopDateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
