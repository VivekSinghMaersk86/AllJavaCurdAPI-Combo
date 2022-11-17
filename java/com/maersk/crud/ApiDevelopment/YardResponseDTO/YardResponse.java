package com.maersk.crud.ApiDevelopment.YardResponseDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_yardmovement2")
public class YardResponse implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="yard_name")
    private  String name;

    @Column(name="equipment_category")
    private  String equipmentCategory;

    @Column(name="category_type")
    private  String categoryType;

    @Column(name="equipment_type")
    private  String equipmentType;

    @Column(name="equipment_name")
    private  String equipmentName;

    @Column(name="equipment_description")
    private  String quipmentDescription;

    @Column(name="equipment_number")
    private  String equipmentNumber;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipmentCategory() {
        return equipmentCategory;
    }

    public void setEquipmentCategory(String equipmentCategory) {
        this.equipmentCategory = equipmentCategory;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getQuipmentDescription() {
        return quipmentDescription;
    }

    public void setQuipmentDescription(String quipmentDescription) {
        this.quipmentDescription = quipmentDescription;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
}
