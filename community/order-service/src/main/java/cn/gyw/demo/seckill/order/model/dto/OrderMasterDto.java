package cn.gyw.demo.seckill.order.model.dto;

import java.math.BigDecimal;

public class OrderMasterDto {
	
	private Integer orderId;

    private Long orderSn;

    private Integer customerId;

    private String shippingUser;

    private Short province;

    /**
     * 市
     * 
     * 表字段: order_master.city
     */
    private Short city;

    /**
     * 区
     * 
     * 表字段: order_master.district
     */
    private Short district;

    /**
     * 地址
     * 
     * 表字段: order_master.address
     */
    private String address;

    /**
     * 支付方式：1现金，2余额，3网银，4支付宝，5微信
     * 
     * 表字段: order_master.payment_method
     */
    private Byte paymentMethod;

    /**
     * 订单金额
     * 
     * 表字段: order_master.order_money
     */
    private BigDecimal orderMoney;

    /**
     * 优惠金额
     * 
     * 表字段: order_master.district_money
     */
    private BigDecimal districtMoney;

    /**
     * 运费金额
     * 
     * 表字段: order_master.shipping_money
     */
    private BigDecimal shippingMoney;

    /**
     * 支付金额
     * 
     * 表字段: order_master.payment_money
     */
    private BigDecimal paymentMoney;
    
    private Byte orderStatus;

    /**
     * 订单积分
     * 
     * 表字段: order_master.order_point
     */
    private Integer orderPoint;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Long getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(Long orderSn) {
		this.orderSn = orderSn;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getShippingUser() {
		return shippingUser;
	}

	public void setShippingUser(String shippingUser) {
		this.shippingUser = shippingUser;
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

	public Short getDistrict() {
		return district;
	}

	public void setDistrict(Short district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Byte getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Byte paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

	public BigDecimal getDistrictMoney() {
		return districtMoney;
	}

	public void setDistrictMoney(BigDecimal districtMoney) {
		this.districtMoney = districtMoney;
	}

	public BigDecimal getShippingMoney() {
		return shippingMoney;
	}

	public void setShippingMoney(BigDecimal shippingMoney) {
		this.shippingMoney = shippingMoney;
	}

	public BigDecimal getPaymentMoney() {
		return paymentMoney;
	}

	public void setPaymentMoney(BigDecimal paymentMoney) {
		this.paymentMoney = paymentMoney;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderPoint() {
		return orderPoint;
	}

	public void setOrderPoint(Integer orderPoint) {
		this.orderPoint = orderPoint;
	}

	@Override
	public String toString() {
		return "OrderMasterDto [orderId=" + orderId + ", orderSn=" + orderSn + ", customerId=" + customerId
				+ ", shippingUser=" + shippingUser + ", province=" + province + ", city=" + city + ", district="
				+ district + ", address=" + address + ", paymentMethod=" + paymentMethod + ", orderMoney=" + orderMoney
				+ ", districtMoney=" + districtMoney + ", shippingMoney=" + shippingMoney + ", paymentMoney="
				+ paymentMoney + ", orderStatus=" + orderStatus + ", orderPoint=" + orderPoint + "]";
	}
    
    
}
