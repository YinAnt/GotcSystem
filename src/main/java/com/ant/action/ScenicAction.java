package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Scenic;
import com.ant.param.Parm;
import com.ant.server.OrdersServer;

import java.util.List;

public class ScenicAction extends BaseAction {
    private Integer scnNo;  // 编号
    private String scnName; // 景区名
    private String scnEnName; // 景区英文名
    private String scnAddr; // 景区地址
    private String scnImgPath;  // 图片地址
    private String scnDescribe; // 描述
    private Float scnFareAdult; // 合作成人票价
    private Float scnFareChile; // 合作儿童票价
    private Float scnOfficalFareAdult; // 门市价（成人）
    private Float scnOfficalFareChild; // 门市价（儿童）
    private Float scnPrice; // 公司售价
    private String scnTel; // 联系电话
    private String scnNet; // 官网网址
    private String scnOpenTime; // 开放时间
    private Long scnCreateTime; // 创建（更新）时间
    private String signNoteTag;

    /**
     * 加载所有景区记录
     * @return
     */
    public String showAllScenic(){
        try {
            List<Scenic> list = OrdersServer.showAllScenic();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("scenic", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }


    public Scenic init(){
        Scenic scenic = new Scenic();
        scenic.setScnNo(scnNo);
        scenic.setScnName(scnName);
        scenic.setScnEnName(scnEnName);
        scenic.setScnAddr(scnAddr);
        scenic.setScnImgPath(scnImgPath);
        scenic.setScnDescribe(scnDescribe);
        scenic.setScnFareAdult(scnFareAdult);
        scenic.setScnFareChile(scnFareChile);
        scenic.setScnOfficalFareAdult(scnOfficalFareAdult);
        scenic.setScnOfficalFareChild(scnOfficalFareChild);
        scenic.setScnPrice(scnPrice);
        scenic.setScnTel(scnTel);
        scenic.setScnNet(scnNet);
        scenic.setScnOpenTime(scnOpenTime);
        scenic.setScnNoteTag(signNoteTag);
        scenic.setScnCreateTime(System.currentTimeMillis());
        return scenic;
    }

    public String getSignNoteTag() {
        return signNoteTag;
    }

    public void setSignNoteTag(String signNoteTag) {
        this.signNoteTag = signNoteTag;
    }

    public String getScnImgPath() {
        return scnImgPath;
    }

    public void setScnImgPath(String scnImgPath) {
        this.scnImgPath = scnImgPath;
    }

    public Integer getScnNo() {
        return scnNo;
    }

    public void setScnNo(Integer scnNo) {
        this.scnNo = scnNo;
    }

    public String getScnName() {
        return scnName;
    }

    public void setScnName(String scnName) {
        this.scnName = scnName;
    }

    public String getScnEnName() {
        return scnEnName;
    }

    public void setScnEnName(String scnEnName) {
        this.scnEnName = scnEnName;
    }

    public String getScnAddr() {
        return scnAddr;
    }

    public void setScnAddr(String scnAddr) {
        this.scnAddr = scnAddr;
    }

    public String getScnDescribe() {
        return scnDescribe;
    }

    public void setScnDescribe(String scnDescribe) {
        this.scnDescribe = scnDescribe;
    }

    public Float getScnFareAdult() {
        return scnFareAdult;
    }

    public void setScnFareAdult(Float scnFareAdult) {
        this.scnFareAdult = scnFareAdult;
    }

    public Float getScnFareChile() {
        return scnFareChile;
    }

    public void setScnFareChile(Float scnFareChile) {
        this.scnFareChile = scnFareChile;
    }

    public Float getScnOfficalFareAdult() {
        return scnOfficalFareAdult;
    }

    public void setScnOfficalFareAdult(Float scnOfficalFareAdult) {
        this.scnOfficalFareAdult = scnOfficalFareAdult;
    }

    public Float getScnOfficalFareChild() {
        return scnOfficalFareChild;
    }

    public void setScnOfficalFareChild(Float scnOfficalFareChild) {
        this.scnOfficalFareChild = scnOfficalFareChild;
    }

    public Float getScnPrice() {
        return scnPrice;
    }

    public void setScnPrice(Float scnPrice) {
        this.scnPrice = scnPrice;
    }

    public String getScnTel() {
        return scnTel;
    }

    public void setScnTel(String scnTel) {
        this.scnTel = scnTel;
    }

    public String getScnNet() {
        return scnNet;
    }

    public void setScnNet(String scnNet) {
        this.scnNet = scnNet;
    }

    public String getScnOpenTime() {
        return scnOpenTime;
    }

    public void setScnOpenTime(String scnOpenTime) {
        this.scnOpenTime = scnOpenTime;
    }

    public Long getScnCreateTime() {
        return scnCreateTime;
    }

    public void setScnCreateTime(Long scnCreateTime) {
        this.scnCreateTime = scnCreateTime;
    }
}
