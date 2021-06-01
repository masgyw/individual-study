package cn.gyw.community.inventory.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WarehouseProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
     * 商品库存ID
     * 
     * 表字段: warehouse_product.wp_id
     */
    private Integer wpId;

    /**
     * 商品ID
     * 
     * 表字段: warehouse_product.product_id
     */
    private Integer productId;

    /**
     * 仓库ID
     * 
     * 表字段: warehouse_product.w_id
     */
    private Short wId;

    /**
     * 当前商品数量
     * 
     * 表字段: warehouse_product.current_cnt
     */
    private Integer currentCnt;

    /**
     * 当前占用数据
     * 
     * 表字段: warehouse_product.lock_cnt
     */
    private Integer lockCnt;

    /**
     * 在途数据
     * 
     * 表字段: warehouse_product.in_transit_cnt
     */
    private Integer inTransitCnt;

    /**
     * 移动加权成本
     * 
     * 表字段: warehouse_product.average_cost
     */
    private BigDecimal averageCost;

    /**
     * 最后修改时间
     * 
     * 表字段: warehouse_product.modified_time
     */
    private Date modifiedTime;

    public Integer getWpId() {
        return wpId;
    }

    public void setWpId(Integer wpId) {
        this.wpId = wpId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Short getwId() {
        return wId;
    }

    public void setwId(Short wId) {
        this.wId = wId;
    }

    public Integer getCurrentCnt() {
        return currentCnt;
    }

    public void setCurrentCnt(Integer currentCnt) {
        this.currentCnt = currentCnt;
    }

    public Integer getLockCnt() {
        return lockCnt;
    }

    public void setLockCnt(Integer lockCnt) {
        this.lockCnt = lockCnt;
    }

    public Integer getInTransitCnt() {
        return inTransitCnt;
    }

    public void setInTransitCnt(Integer inTransitCnt) {
        this.inTransitCnt = inTransitCnt;
    }

    public BigDecimal getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}