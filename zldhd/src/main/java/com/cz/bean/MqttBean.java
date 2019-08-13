package com.cz.bean;

import java.io.Serializable;

public class MqttBean implements Serializable {


    private String mqfromserver;//"paycallback"
    private String channelid; //"1576"  //通道id
    private String orderid;//"2",  停车场id
    private String plate;//"3"  //车牌
    private String money;//"4"  //缴费金额
    private String curtime;//"2019-08-12 16;00;00"

    public String getMqfromserver() { return mqfromserver; }
    public void setMqfromserver(String mqfromserver) { this.mqfromserver = mqfromserver; }
    public String getChannelid() { return channelid; }
    public void setChannelid(String channelid) { this.channelid = channelid; }
    public String getOrderid() { return orderid; }
    public void setOrderid(String orderid) { this.orderid = orderid; }
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public String getMoney() { return money; }
    public void setMoney(String money) { this.money = money; }
    public String getCurtime() { return curtime; }
    public void setCurtime(String curtime) { this.curtime = curtime; }

    @Override
    public String toString() {
        return "MqttBean{" +
                "mqfromserver='" + mqfromserver + '\'' +
                ", channelid='" + channelid + '\'' +
                ", orderid='" + orderid + '\'' +
                ", plate='" + plate + '\'' +
                ", money='" + money + '\'' +
                ", curtime='" + curtime + '\'' +
                '}';
    }

}
