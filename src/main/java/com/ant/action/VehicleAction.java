package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Vehicle;
import com.ant.param.Parm;
import com.ant.server.OrdersServer;

import java.util.List;

public class VehicleAction extends BaseAction{
    private Integer vhcNo; // 编号
    private String vhcNum;  // 车牌号
    private String vhcModel;    // 车型
    private Integer vhcSeat;    // 座位数
    private String vhcAgent;    // 责任人
    private String vhcDescribe; // 描述
    private String vhcState;    // 状态
    private Long vhcCreateTime; // 创建（更新）时间

    /**
     * 加载所有车辆记录
     * @return
     */
    public String showAllVehicle(){
        try {
            List<Vehicle> list = OrdersServer.showAllVehicle();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("vehicle", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }


    /**
     * 添加车辆
     * @return
     */
    public String addVehicle(){
        Vehicle vehicle = new Vehicle();
        try {
            vehicle = OrdersServer.addVehicle(vehicle);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("vehicle", vehicle);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public Vehicle init(){
        Vehicle vehicle = new Vehicle();
        vehicle.setVhcNo(vhcNo);
        vehicle.setVhcNum(vhcNum);
        vehicle.setVhcModel(vhcModel);
        vehicle.setVhcSeat(vhcSeat);
        vehicle.setVhcAgent(vhcAgent);
        vehicle.setVhcDescribe(vhcDescribe);
        vehicle.setVhcState(vhcState);
        vehicle.setVhcCreateTime(System.currentTimeMillis());
        return vehicle;
    }

    public Integer getVhcNo() {
        return vhcNo;
    }

    public void setVhcNo(Integer vhcNo) {
        this.vhcNo = vhcNo;
    }

    public String getVhcNum() {
        return vhcNum;
    }

    public void setVhcNum(String vhcNum) {
        this.vhcNum = vhcNum;
    }

    public String getVhcModel() {
        return vhcModel;
    }

    public void setVhcModel(String vhcModel) {
        this.vhcModel = vhcModel;
    }

    public Integer getVhcSeat() {
        return vhcSeat;
    }

    public void setVhcSeat(Integer vhcSeat) {
        this.vhcSeat = vhcSeat;
    }

    public String getVhcAgent() {
        return vhcAgent;
    }

    public void setVhcAgent(String vhcAgent) {
        this.vhcAgent = vhcAgent;
    }

    public String getVhcDescribe() {
        return vhcDescribe;
    }

    public void setVhcDescribe(String vhcDescribe) {
        this.vhcDescribe = vhcDescribe;
    }

    public String getVhcState() {
        return vhcState;
    }

    public void setVhcState(String vhcState) {
        this.vhcState = vhcState;
    }

    public Long getVhcCreateTime() {
        return vhcCreateTime;
    }

    public void setVhcCreateTime(Long vhcCreateTime) {
        this.vhcCreateTime = vhcCreateTime;
    }
}
