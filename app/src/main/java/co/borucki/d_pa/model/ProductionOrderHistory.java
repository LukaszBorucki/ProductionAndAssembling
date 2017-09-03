package co.borucki.d_pa.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "productionOrderHistory")
public class ProductionOrderHistory {
    @DatabaseField(columnName = "id", id = true)
    private long idOrderTurning;
    @DatabaseField(columnName = "orderId")
    private String orderId;
    @DatabaseField(columnName = "date")
    private String date;
    @DatabaseField(columnName = "time")
    private String time;
    @DatabaseField(columnName = "employee")
    private String employee;
    @DatabaseField(columnName = "contents")
    private String contents;

    public ProductionOrderHistory() {
    }

    public ProductionOrderHistory(long idOrderTurning, String orderId, String date, String time, String employee, String contents) {
        this.idOrderTurning = idOrderTurning;
        this.orderId = orderId;
        this.date = date;
        this.time = time;
        this.employee = employee;
        this.contents = contents;
    }

    public long getIdOrderTurning() {
        return idOrderTurning;
    }

    public void setIdOrderTurning(long idOrderTurning) {
        this.idOrderTurning = idOrderTurning;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
