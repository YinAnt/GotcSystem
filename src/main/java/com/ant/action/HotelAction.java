package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Hotel;
import com.ant.param.Parm;
import com.ant.server.OrdersServer;

import java.util.List;

public class HotelAction extends BaseAction {
    private Integer htlNo;  // 编号
    private String htlName; // 酒店名
    private Integer htlLevel;   // 酒店星级
    private String htlAddr; // 酒店地址
    private String htlRoom;    // 房型
    private Float htlFare;  // 合作价格
    private Float htlPrice; // 售价
    private Float htlOfficalFare;  // 门市价
    private String htlTel;  // 电话
    private String htlNet;  // 网址
    private Long htlCreateTime; // 创建（更新）时间

    /**
     * 加载所有酒店信息
     * @return
     */
    public String showAllHotel(){
        try {
            List<Hotel> list = OrdersServer.showAllHotel();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("hotel", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public Hotel init(){
        Hotel hotel = new Hotel();
        hotel.setHtlNo(htlNo);
        hotel.setHtlName(htlName);
        hotel.setHtlLevel(htlLevel);
        hotel.setHtlAddr(htlAddr);
        hotel.setHtlRoom(htlRoom);
        hotel.setHtlFare(htlFare);
        hotel.setHtlOfficalFare(htlOfficalFare);
        hotel.setHtlPrice(htlPrice);
        hotel.setHtlTel(htlTel);
        hotel.setHtlNet(htlNet);
        return hotel;
    }

    public Integer getHtlNo() {
        return htlNo;
    }

    public void setHtlNo(Integer htlNo) {
        this.htlNo = htlNo;
    }

    public String getHtlName() {
        return htlName;
    }

    public void setHtlName(String htlName) {
        this.htlName = htlName;
    }

    public Integer getHtlLevel() {
        return htlLevel;
    }

    public void setHtlLevel(Integer htlLevel) {
        this.htlLevel = htlLevel;
    }

    public String getHtlAddr() {
        return htlAddr;
    }

    public void setHtlAddr(String htlAddr) {
        this.htlAddr = htlAddr;
    }

    public String getHtlRoom() {
        return htlRoom;
    }

    public void setHtlRoom(String htlRoom) {
        this.htlRoom = htlRoom;
    }

    public Float getHtlFare() {
        return htlFare;
    }

    public void setHtlFare(Float htlFare) {
        this.htlFare = htlFare;
    }

    public Float getHtlOfficalFare() {
        return htlOfficalFare;
    }

    public void setHtlOfficalFare(Float htlOfficalFare) {
        this.htlOfficalFare = htlOfficalFare;
    }

    public String getHtlTel() {
        return htlTel;
    }

    public void setHtlTel(String htlTel) {
        this.htlTel = htlTel;
    }

    public String getHtlNet() {
        return htlNet;
    }

    public void setHtlNet(String htlNet) {
        this.htlNet = htlNet;
    }

    public Long getHtlCreateTime() {
        return htlCreateTime;
    }

    public void setHtlCreateTime(Long htlCreateTime) {
        this.htlCreateTime = htlCreateTime;
    }

    public Float getHtlPrice() {
        return htlPrice;
    }

    public void setHtlPrice(Float htlPrice) {
        this.htlPrice = htlPrice;
    }
}
