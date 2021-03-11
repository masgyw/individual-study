package cn.gyw.platform.common.web.model;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = 2935311783781869347L;

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    private String direction = "ASC";
    private String property;
    private Boolean ignoreCase = true;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Boolean getIgnoreCase() {
        return ignoreCase;
    }

    public void setIgnoreCase(Boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    @Override
    public String toString() {
        return "Order [direction=" + direction + ", property=" + property + ", ignoreCase=" + ignoreCase + "]";
    }
}
