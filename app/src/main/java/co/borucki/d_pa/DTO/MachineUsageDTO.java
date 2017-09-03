package co.borucki.d_pa.DTO;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

public class MachineUsageDTO {
    private int id;
    private String machinesId;
    private String date;
    private String startDateTime;
    private String stopDateTime;
    private int status;
    private String employee;
    private String orderId;

    public MachineUsageDTO() {
    }

    public MachineUsageDTO(int id, String machinesId, String date, String startDateTime, String stopDateTime, int status, String employee, String orderId) {
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
