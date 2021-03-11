package cn.gyw.community.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@TableName(value = "apilog0")
public class SysLog {

    // 创建时间
    public static final String CREATED_TIME = "gmtcreate";

    private String sequencenum;

    /**
     * 当前操作人id
     */
    private String loginaccount;

    /**
     * 服务api
     */
    private String host;

    private String port;

    /**
     * 操作请求的链接
     */
    private String actionurl;

    /**
     * 执行的模块
     */
    private String module;

    /**
     * 执行的方法
     */
    private String method;

    private String responsecode;

    private String responsedata;

    /**
     * 执行的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtcreate;

    public String getSequencenum() {
        return sequencenum;
    }

    public void setSequencenum(String sequencenum) {
        this.sequencenum = sequencenum;
    }

    public String getLoginaccount() {
        return loginaccount;
    }

    public void setLoginaccount(String loginaccount) {
        this.loginaccount = loginaccount;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getActionurl() {
        return actionurl;
    }

    public void setActionurl(String actionurl) {
        this.actionurl = actionurl;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public String getResponsedata() {
        return responsedata;
    }

    public void setResponsedata(String responsedata) {
        this.responsedata = responsedata;
    }

    public Date getGmtcreate() {
        return gmtcreate;
    }

    public void setGmtcreate(Date gmtcreate) {
        this.gmtcreate = gmtcreate;
    }
}
