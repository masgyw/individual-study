package cn.gyw.corejava.jdk.jdk5;

/**
 * Created by guanyw on 2017/9/12.
 */
public class Bean {
    private int id;
    private String name;
    private String aPoint;
    private String zPoint;
    private String tStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getaPoint() {
        return aPoint;
    }

    public void setaPoint(String aPoint) {
        this.aPoint = aPoint;
    }

    public String getzPoint() {
        return zPoint;
    }

    public void setzPoint(String zPoint) {
        this.zPoint = zPoint;
    }

    public String gettStatus() {
        return tStatus;
    }

    public void settStatus(String tStatus) {
        this.tStatus = tStatus;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aPoint='" + aPoint + '\'' +
                ", zPoint='" + zPoint + '\'' +
                ", tStatus='" + tStatus + '\'' +
                '}';
    }
}
