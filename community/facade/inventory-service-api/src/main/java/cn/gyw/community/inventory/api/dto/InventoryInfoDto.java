package cn.gyw.community.inventory.api.dto;

import java.util.Date;

public class InventoryInfoDto {
    /**
     * 仓库ID
     */
    private Short wId;

    /**
     * 仓库编码
     */
    private String inventorySn;

    /**
     * 仓库名称
     */
    private String warehoustName;

    /**
     * 仓库电话
     */
    private String inventoryPhone;

    /**
     * 仓库联系人
     */
    private String contact;

    /**
     * 省
     */
    private Short province;

    /**
     * 市
     */
    private Short city;

    /**
     * 区
     */
    private Short distrct;

    /**
     * 仓库地址
     */
    private String address;

    /**
     * 仓库状态：0禁用，1启用
     */
    private Byte inventoryStatus;

    /**
     * 最后修改时间
     */
    private Date modifiedTime;

    /**
     * 获取仓库ID
     *
     * @return w_id - 仓库ID
     */
    public Short getwId() {
        return wId;
    }

    /**
     * 设置仓库ID
     *
     * @param wId 仓库ID
     */
    public void setwId(Short wId) {
        this.wId = wId;
    }

    /**
     * 获取仓库编码
     *
     * @return inventory_sn - 仓库编码
     */
    public String getInventorySn() {
        return inventorySn;
    }

    /**
     * 设置仓库编码
     *
     * @param inventorySn 仓库编码
     */
    public void setInventorySn(String inventorySn) {
        this.inventorySn = inventorySn == null ? null : inventorySn.trim();
    }

    /**
     * 获取仓库名称
     *
     * @return warehoust_name - 仓库名称
     */
    public String getWarehoustName() {
        return warehoustName;
    }

    /**
     * 设置仓库名称
     *
     * @param warehoustName 仓库名称
     */
    public void setWarehoustName(String warehoustName) {
        this.warehoustName = warehoustName == null ? null : warehoustName.trim();
    }

    /**
     * 获取仓库电话
     *
     * @return inventory_phone - 仓库电话
     */
    public String getInventoryPhone() {
        return inventoryPhone;
    }

    /**
     * 设置仓库电话
     *
     * @param inventoryPhone 仓库电话
     */
    public void setInventoryPhone(String inventoryPhone) {
        this.inventoryPhone = inventoryPhone == null ? null : inventoryPhone.trim();
    }

    /**
     * 获取仓库联系人
     *
     * @return contact - 仓库联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置仓库联系人
     *
     * @param contact 仓库联系人
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public Short getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(Short province) {
        this.province = province;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public Short getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(Short city) {
        this.city = city;
    }

    /**
     * 获取区
     *
     * @return distrct - 区
     */
    public Short getDistrct() {
        return distrct;
    }

    /**
     * 设置区
     *
     * @param distrct 区
     */
    public void setDistrct(Short distrct) {
        this.distrct = distrct;
    }

    /**
     * 获取仓库地址
     *
     * @return address - 仓库地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置仓库地址
     *
     * @param address 仓库地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取仓库状态：0禁用，1启用
     *
     * @return inventory_status - 仓库状态：0禁用，1启用
     */
    public Byte getInventoryStatus() {
        return inventoryStatus;
    }

    /**
     * 设置仓库状态：0禁用，1启用
     *
     * @param inventoryStatus 仓库状态：0禁用，1启用
     */
    public void setInventoryStatus(Byte inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    /**
     * 获取最后修改时间
     *
     * @return modified_time - 最后修改时间
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 设置最后修改时间
     *
     * @param modifiedTime 最后修改时间
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}