package co.borucki.d_pa.DTO;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "orderProduction")
public class ProductionOrdersDTO {
    @DatabaseField(columnName = "id", id = true)
    private String idOrderTurning;
    @DatabaseField(columnName = "orderProduct")
    private String orderProduct;
    @DatabaseField(columnName = "orderStatus")
    private String orderStatus;
    @DatabaseField(columnName = "orderDate")
    private String orderDate;
    @DatabaseField(columnName = "orderTermOfRealization")
    private String orderTermOfRealization;
    @DatabaseField(columnName = "orderQuantity")
    private int orderQuantity;
    @DatabaseField(columnName = "orderEmployee")
    private String orderEmployee;
    @DatabaseField(columnName = "orderMachineId")
    private String orderMachineId;

    public ProductionOrdersDTO() {
    }

    public ProductionOrdersDTO(String idOrderTurning, String orderProduct, String orderStatus
            , String orderDate, String orderTermOfRealization, int orderQuantity
            , String orderEmployee, String orderMachineId) {
        this.idOrderTurning = idOrderTurning;
        this.orderProduct = orderProduct;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.orderTermOfRealization = orderTermOfRealization;
        this.orderQuantity = orderQuantity;
        this.orderEmployee = orderEmployee;
        this.orderMachineId = orderMachineId;
    }

    public String getIdOrderTurning() {
        return idOrderTurning;
    }

    public void setIdOrderTurning(String idOrderTurning) {
        this.idOrderTurning = idOrderTurning;
    }

    public String getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(String orderProduct) {
        this.orderProduct = orderProduct;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTermOfRealization() {
        return orderTermOfRealization;
    }

    public void setOrderTermOfRealization(String orderTermOfRealization) {
        this.orderTermOfRealization = orderTermOfRealization;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderEmployee() {
        return orderEmployee;
    }

    public void setOrderEmployee(String orderEmployee) {
        this.orderEmployee = orderEmployee;
    }

    public String getOrderMachineId() {
        return orderMachineId;
    }

    public void setOrderMachineId(String orderMachineId) {
        this.orderMachineId = orderMachineId;
    }
}
