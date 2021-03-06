package co.borucki.d_pa.DTO;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

public class ProductionOrderRealizationDTO {
    private int id;
    private String orderId;
    private String saveDate;
    private String startDateTime;
    private String stopDateTime;
    private int quantity;
    private String machineId;
    private float unitTime;
    private String speedSpindle1;
    private String speedSpindle2;
    private String feederateWorking;
    private String feederateFast;

    public ProductionOrderRealizationDTO() {
    }

    public ProductionOrderRealizationDTO(int id, String orderId, String saveDate, String startDateTime
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
