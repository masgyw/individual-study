package cn.gyw.demo.seckill.order.api.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderMaster {
    /**
     * 订单ID
     * 
     * 表字段: order_master.order_id
     */
    private Integer orderId;

    /**
     * 订单编号 yyyymmddnnnnnnnn
     * 
     * 表字段: order_master.order_sn
     */
    private Long orderSn;

    /**
     * 下单人ID
     * 
     * 表字段: order_master.customer_id
     */
    private Integer customerId;

    /**
     * 收货人姓名
     * 
     * 表字段: order_master.shipping_user
     */
    private String shippingUser;

    /**
     * 省
     * 
     * 表字段: order_master.province
     */
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

    /**
     * 快递公司名称
     * 
     * 表字段: order_master.shipping_comp_name
     */
    private String shippingCompName;

    /**
     * 快递单号
     * 
     * 表字段: order_master.shipping_sn
     */
    private String shippingSn;

    /**
     * 下单时间
     * 
     * 表字段: order_master.create_time
     */
    private Date createTime;

    /**
     * 发货时间
     * 
     * 表字段: order_master.shipping_time
     */
    private Date shippingTime;

    /**
     * 支付时间
     * 
     * 表字段: order_master.pay_time
     */
    private Date payTime;

    /**
     * 收货时间
     * 
     * 表字段: order_master.receive_time
     */
    private Date receiveTime;

    /**
     * 订单状态
     * 0: 初始化；1：更新中；2：成功；3：失败
     * 表字段: order_master.order_status
     */
    private Byte orderStatus;

    /**
     * 订单积分
     * 
     * 表字段: order_master.order_point
     */
    private Integer orderPoint;

    /**
     * 发票抬头
     * 
     * 表字段: order_master.invoice_time
     */
    private String invoiceTime;

    /**
     * 最后修改时间
     * 
     * 表字段: order_master.modified_time
     */
    private Date modifiedTime;

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
        this.shippingUser = shippingUser == null ? null : shippingUser.trim();
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
        this.address = address == null ? null : address.trim();
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

    public String getShippingCompName() {
        return shippingCompName;
    }

    public void setShippingCompName(String shippingCompName) {
        this.shippingCompName = shippingCompName == null ? null : shippingCompName.trim();
    }

    public String getShippingSn() {
        return shippingSn;
    }

    public void setShippingSn(String shippingSn) {
        this.shippingSn = shippingSn == null ? null : shippingSn.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
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

    public String getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(String invoiceTime) {
        this.invoiceTime = invoiceTime == null ? null : invoiceTime.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}