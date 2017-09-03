package co.borucki.d_pa.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "productionOrderRealization")
public class ProductionOrderRealization {
    @DatabaseField(columnName = "id", index = true)
    private int id;
    @DatabaseField(columnName = "orderId")
    private String orderId;
    @DatabaseField(columnName = "saveDate")
    private String saveDate;
    @DatabaseField(columnName = "startDateTime")
    private String startDateTime;
    @DatabaseField(columnName = "stopDateTime")
    private String stopDateTime;
    @DatabaseField(columnName = "quantity")
    private int quantity;
    @DatabaseField(columnName = "machineId")
    private String machineId;
    @DatabaseField(columnName = "unitTime")
    private float unitTime;
    @DatabaseField(columnName = "speedSpindle1")
    private String speedSpindle1;
    @DatabaseField(columnName = "speedSpindle2")
    private String speedSpindle2;
    @DatabaseField(columnName = "feederateWorking")
    private String feederateWorking;
    @DatabaseField(columnName = "feederateFast")
    private String feederateFast;

    public ProductionOrderRealization() {
    }

    public ProductionOrderRealization(int id, String orderId, String saveDate, String startDateTime
            , String stopDateTime, int quantity, String machineId, float unitTime
            , String speedSpindle1, String speedSpindle2, String feederateWorking
            , String feederateFast) {
        this.id = id;
        this.orderId = orderId;
        this.saveDate = saveDate;
        this.startDateTime = startDateTime;
        this.stopDateTime = stopDateTime;
        this.quantity = quantity;
        this.machineId = machineId;
        this.unitTime = unitTime;
        this.speedSpindle1 = speedSpindle1;
        this.speedSpindle2 = speedSpindle2;
        this.feederateWorking = feederateWorking;
        this.feederateFast = feederateFast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(String saveDate) {
        this.saveDate = saveDate;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public float getUnitTime() {
        return unitTime;
    }

    public void setUnitTime(float unitTime) {
        this.unitTime = unitTime;
    }

    public String getSpeedSpindle1() {
        return speedSpindle1;
    }

    public void setSpeedSpindle1(String speedSpindle1) {
        this.speedSpindle1 = speedSpindle1;
    }

    public String getSpeedSpindle2() {
        return speedSpindle2;
    }

    public void setSpeedSpindle2(String speedSpindle2) {
        this.speedSpindle2 = speedSpindle2;
    }

    public String getFeederateWorking() {
        return feederateWorking;
    }

    public void setFeederateWorking(String feederateWorking) {
        this.feederateWorking = feederateWorking;
    }

    public String getFeederateFast() {
        return feederateFast;
    }

    public void setFeederateFast(String feederateFast) {
        this.feederateFast = feederateFast;
    }
}
