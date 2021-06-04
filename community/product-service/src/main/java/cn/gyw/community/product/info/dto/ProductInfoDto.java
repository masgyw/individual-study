package cn.gyw.community.product.info.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.gyw.community.product.pic.entity.ProductPicInfo;

public class ProductInfoDto {

	private Integer productId;

	private String productCore;

	private String productName;

	private String barCode;

	private Integer brandId;

	private Short oneCategoryId;

	private Short twoCategoryId;

	private Short threeCategoryId;

	private Integer supplierId;

	private BigDecimal price;

	private BigDecimal averageCost;

	private Byte publishStatus;

	private Byte auditStatus;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date productionDate;

	private Integer shelfLife;

	private String descript;

	private ProductPicInfo productPicInfo;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductCore() {
		return productCore;
	}

	public void setProductCore(String productCore) {
		this.productCore = productCore;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public Short getOneCategoryId() {
		return oneCategoryId;
	}

	public void setOneCategoryId(Short oneCategoryId) {
		this.oneCategoryId = oneCategoryId;
	}

	public Short getTwoCategoryId() {
		return twoCategoryId;
	}

	public void setTwoCategoryId(Short twoCategoryId) {
		this.twoCategoryId = twoCategoryId;
	}

	public Short getThreeCategoryId() {
		return threeCategoryId;
	}

	public void setThreeCategoryId(Short threeCategoryId) {
		this.threeCategoryId = threeCategoryId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAverageCost() {
		return averageCost;
	}

	public void setAverageCost(BigDecimal averageCost) {
		this.averageCost = averageCost;
	}

	public Byte getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(Byte publishStatus) {
		this.publishStatus = publishStatus;
	}

	public Byte getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Integer getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public ProductPicInfo getProductPicInfo() {
		return productPicInfo;
	}

	public void setProductPicInfo(ProductPicInfo productPicInfo) {
		this.productPicInfo = productPicInfo;
	}

}
