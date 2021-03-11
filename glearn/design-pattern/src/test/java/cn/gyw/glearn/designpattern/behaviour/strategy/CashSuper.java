package cn.gyw.glearn.designpattern.behaviour.strategy;

public abstract class CashSuper {

    /**
     * 现金收取超类的方法，收取现金
     * @param money 原价
     * @return 当前价（优惠后）
     */
    public abstract double acceptCash(double money);
}
