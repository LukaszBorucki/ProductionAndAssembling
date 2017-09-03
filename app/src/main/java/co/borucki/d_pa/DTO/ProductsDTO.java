package co.borucki.d_pa.DTO;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

public class ProductsDTO {
    private String code;
    private String series;
    private double weight;
    private int quantityInBox;
    private double length;
    private String material;
    private int assembling;
    private String description;
    private String picture;
    private String technicalDrawing;

    public ProductsDTO() {
    }

    public ProductsDTO(String code, String series, double weight, int quantityInBox, double length
            , String material, int assembling, String description, String picture
            , String technicalDrawing) {
        this.code = code;
        this.series = series;
        this.weight = weight;
        this.quantityInBox = quantityInBox;
        this.length = length;
        this.material = material;
        this.assembling = assembling;
        this.description = description;
        this.picture = picture;
        this.technicalDrawing = technicalDrawing;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantityInBox() {
        return quantityInBox;
    }

    public void setQuantityInBox(int quantityInBox) {
        this.quantityInBox = quantityInBox;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAssembling() {
        return assembling;
    }

    public void setAssembling(int assembling) {
        this.assembling = assembling;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTechnicalDrawing() {
        return technicalDrawing;
    }

    public void setTechnicalDrawing(String technicalDrawing) {
        this.technicalDrawing = technicalDrawing;
    }
}
