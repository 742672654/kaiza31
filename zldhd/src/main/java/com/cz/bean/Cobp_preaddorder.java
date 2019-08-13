package com.cz.bean;

public class Cobp_preaddorder {

    private String info;//"1"
    private String own;//"0","
    private String other;//"0","
    private String orderid;//"35123398"
    private String ismonthuser;//"0""
    private String preorderid;//null"
    private String isyuyue;//"0"

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }
    public String getOwn() { return own; }
    public void setOwn(String own) { this.own = own; }
    public String getOther() { return other; }
    public void setOther(String other) { this.other = other; }
    public String getOrderid() { return orderid; }
    public void setOrderid(String orderid) { this.orderid = orderid; }
    public String getIsmonthuser() { return ismonthuser; }
    public void setIsmonthuser(String ismonthuser) { this.ismonthuser = ismonthuser; }
    public String getPreorderid() { return preorderid; }
    public void setPreorderid(String preorderid) { this.preorderid = preorderid; }
    public String getIsyuyue() { return isyuyue; }
    public void setIsyuyue(String isyuyue) { this.isyuyue = isyuyue; }

    @Override
    public String toString() {
        return "cobp_preaddorder{" +
                "info='" + info + '\'' +
                ", own='" + own + '\'' +
                ", other='" + other + '\'' +
                ", orderid='" + orderid + '\'' +
                ", ismonthuser='" + ismonthuser + '\'' +
                ", preorderid='" + preorderid + '\'' +
                ", isyuyue='" + isyuyue + '\'' +
                '}';
    }

}
