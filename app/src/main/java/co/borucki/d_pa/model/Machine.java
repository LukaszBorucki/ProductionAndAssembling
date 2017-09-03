package co.borucki.d_pa.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "machines")
public class Machine {
    @DatabaseField(columnName = "id", index = true)
    private String id;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "manufactureYear")
    private String manufactureYear;
    @DatabaseField(columnName = "trademark")
    private String trademark;
    @DatabaseField(columnName = "processingMaterial")
    private String procesingMaterial;
    @DatabaseField(columnName = "status")
    private int status;

    public Machine() {
    }

    public Machine(String id, String name, String manufactureYear, String trademark, String procesingMaterial, int status) {
        this.id = id;
        this.name = name;
        this.manufactureYear = manufactureYear;
        this.trademark = trademark;
        this.procesingMaterial = procesingMaterial;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getProcesingMaterial() {
        return procesingMaterial;
    }

    public void setProcesingMaterial(String procesingMaterial) {
        this.procesingMaterial = procesingMaterial;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
