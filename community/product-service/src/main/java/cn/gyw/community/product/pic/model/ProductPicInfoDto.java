package cn.gyw.community.product.pic.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductPicInfoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 商品图片ID
     * 
     * 表字段: product_pic_info.product_pic_id
     */
    private Integer productPicId;
    
	/**
     * 商品ID
     * 
     * 表字段: product_pic_info.product_id
     */
    private Integer productId;

    /**
     * 图片描述
     * 
     * 表字段: product_pic_info.pic_desc
     */
    private String picDesc;

    /**
     * 图片URL
     * 
     * 表字段: product_pic_info.pic_url
     */
    private String picUrl;

    /**
     * 是否主图：0.非主图1.主图
     * 
     * 表字段: product_pic_info.is_master
     */
    private Byte isMaster;

    /**
     * 图片排序
     * 
     * 表字段: product_pic_info.pic_order
     */
    private Byte picOrder;

    /**
     * 图片是否有效：0无效 1有效
     * 
     * 表字段: product_pic_info.pic_status
     */
    private Byte picStatus;

    /**
     * 最后修改时间
     * 
     * 表字段: product_pic_info.modified_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

	public Integer getProductPicId() {
		return productPicId;
	}

	public void setProductPicId(Integer productPicId) {
		this.productPicId = productPicId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getPicDesc() {
		return picDesc;
	}

	public void setPicDesc(String picDesc) {
		this.picDesc = picDesc;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Byte getIsMaster() {
		return isMaster;
	}

	public void setIsMaster(Byte isMaster) {
		this.isMaster = isMaster;
	}

	public Byte getPicOrder() {
		return picOrder;
	}

	public void setPicOrder(Byte picOrder) {
		this.picOrder = picOrder;
	}

	public Byte getPicStatus() {
		return picStatus;
	}

	public void setPicStatus(Byte picStatus) {
		this.picStatus = picStatus;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
}
