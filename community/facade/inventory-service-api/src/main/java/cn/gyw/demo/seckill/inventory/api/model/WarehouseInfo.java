package cn.gyw.demo.seckill.inventory.api.model;

import java.io.Serializable;
import java.util.Date;

public class WarehouseInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
     * 仓库ID
     * 
     * 表字段: warehouse_info.w_id
     */
    private Short wId;

    /**
     * 仓库编码
     * 
     * 表字段: warehouse_info.warehouse_sn
     */
    private String warehouseSn;

    /**
     * 仓库名称
     * 
     * 表字段: warehouse_info.warehoust_name
     */
    private String warehoustName;

    /**
     * 仓库电话
     * 
     * 表字段: warehouse_info.warehouse_phone
     */
    private String warehousePhone;

    /**
     * 仓库联系人
     * 
     * 表字段: warehouse_info.contact
     */
    private String contact;

    /**
     * 省
     * 
     * 表字段: warehouse_info.province
     */
    private Short province;

    /**
     * 市
     * 
     * 表字段: warehouse_info.city
     */
    private Short city;

    /**
     * 区
     * 
     * 表字段: warehouse_info.distrct
     */
    private Short distrct;

    /**
     * 仓库地址
     * 
     * 表字段: warehouse_info.address
     */
    private String address;

    /**
     * 仓库状态：0禁用，1启用
     * 
     * 表字段: warehouse_info.warehouse_status
     */
    private Byte warehouseStatus;

    /**
     * 最后修改时间
     * 
     * 表字段: warehouse_info.modified_time
     */
    private Date modifiedTime;

    public Short getwId() {
        return wId;
    }

    public void setwId(Short wId) {
        this.wId = wId;
    }

    public String getWarehouseSn() {
        return warehouseSn;
    }

    public void setWarehouseSn(String warehouseSn) {
        this.warehouseSn = warehouseSn;
    }

    public String getWarehoustName() {
        return warehoustName;
    }

    public void setWarehoustName(String warehoustName) {
        this.warehoustName = warehoustName;
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Short getProvince() {
        return province;
    }

    public void setProvince(Short province) {
        this.province = province;
    }

    public Short getCity() {
        return city;
    }

    public void setCity(Short city) {
        this.city = city;
    }

    public Short getDistrct() {
        return distrct;
    }

    public void setDistrct(Short distrct) {
        this.distrct = distrct;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(Byte warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}