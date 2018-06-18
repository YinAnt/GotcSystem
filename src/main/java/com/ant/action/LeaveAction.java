package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Holiday;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.server.AttendanceServer;
import com.ant.util.Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LeaveAction extends BaseAction {
    private int id;
    // holiday
    private Long hldNo;   // 工单号
    private Integer hldEmpNo;   // 申请人
    private Long hldCreateTime; // 创建时间
    private Long hldStartTime; // 开始时间
    private Long hldEndTime; // 结束时间
    private Float hldDays; // 请假天数
    private String hldType; // 请假类型
    private String hldReason; // 请假原因
    private Integer hldHandle; // 处理人
    private String hldHandleName; // 处理人姓名
    private Long hldHandleTime; // 处理时间
    private Float hldHandleDays; // 处理时长
    private String hldResult; // 处理结果
    private Integer hldState; // 工单状态

    private String startTimeStr; // 请假开始时间
    private String endTimeStr; // 请假结束时间

    private Integer uEmpNo = 1002;
    /**
     * 处理请假信息
     *
     * @return
     */
    public String handleLeave() {
        Holiday holiday = new Holiday();
        holiday.setHldNo(hldNo);
        holiday.setHldResult(hldResult);
        try {
            holiday = AttendanceServer.handleLeave(holiday);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("holiday", holiday);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }


    /**
     * 请假申请
     *
     * @return
     */
    public String AskForLeave() {
        System.out.println("AskForLeave");
        Holiday holiday = init();
        System.out.println("holiday" + holiday.toString());
        try {
            holiday = AttendanceServer.AskForLeave(holiday);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("holiday", holiday);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 根据 处理人 查询所有的请假记录
     *
     * @return
     */
    public String showMyHandleHoliday() {
        try {
            List<Holiday> list = AttendanceServer.showMyHandleHoliday(hldHandleName);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("holiday", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 根据 处理人 查询所有 待处理 的请假记录
     *
     * @return
     */
    public String showWaitForMyHandleHoliday() {
        System.out.println("handleName:" + hldHandleName);
        try {
            List<Holiday> list = AttendanceServer.showWaitForMyHandleHoliday(hldHandleName);
            System.out.println("list action:" + list.toString());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("holiday", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 查询所有人的请假记录
     *
     * @return
     */
    public String showAllHoliday() {
        try {
            List<Holiday> list = AttendanceServer.showAllHoliday();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("holiday", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 根据工号查询请假记录
     *
     * @return
     */
    public String showAllHolidayByEmpNo() {
        System.out.println("showAllHolidayByEmpNo");
//        System.out.println("hldEmpNo:"+hldEmpNo);
        Holiday holiday = new Holiday();
        holiday.setHldEmpNo(hldEmpNo);
        if (hldEmpNo == null){
            holiday.setHldEmpNo(uEmpNo);
        }
        System.out.println("holiday:"+holiday.toString());
        try {
            List<Holiday> list = AttendanceServer.showAllHolidayByEmpNo(holiday.getHldEmpNo());
            System.out.println("holiday list:"+list.toString());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("holiday", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    private Holiday init() {
        System.out.println("2:");
        Holiday holiday = new Holiday();

        if (startTimeStr != null && endTimeStr != null) {
            System.out.println("startTimeStr:" + startTimeStr);
            System.out.println("endTimeStr:" + endTimeStr);

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date startDate = dateFormat.parse(startTimeStr);
                Date endDate = dateFormat.parse(endTimeStr);
                // 验证date
                System.out.println("startDate:" + startDate.toString());
                System.out.println("endDate:" + endDate.toString());
                // 验证日期
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("startDate format:" + dateFormat2.format(startDate));
                System.out.println("endDate format:" + dateFormat2.format(endDate));

                // 毫秒数
                System.out.println("startDate:" + startDate.getTime());
                System.out.println("endDate:" + endDate.getTime());

                hldStartTime = startDate.getTime();
                hldEndTime = endDate.getTime() + Tools.TIME_SIZE_DAY - 1; // 设置成结束当天的23：59：59
                System.out.println("hldEndTime format 23:59:59:" + dateFormat2.format(hldEndTime));

            } catch (ParseException e) {
                System.out.println("date error:");
                e.printStackTrace();
            }
//        System.out.println("-----------------------------------------------:");
        }

        holiday.setHldNo(System.currentTimeMillis()); // 工单号
        holiday.setHldEmpNo(hldEmpNo);
        holiday.setHldCreateTime(System.currentTimeMillis());
        holiday.setHldStartTime(hldStartTime);
        holiday.setHldEndTime(hldEndTime);
        holiday.setHldDays(Tools.differentDaysByMillisecond(hldStartTime, hldEndTime)); // 请假天数
        holiday.setHldType(hldType);
        holiday.setHldReason(hldReason);
        holiday.setHldHandle(hldHandle);
        holiday.setHldHandleTime(hldHandleTime);
        holiday.setHldHandleDays(hldHandleDays);
        holiday.setHldResult(hldResult);
        holiday.setHldState(State.HLD_STATE_WAIT);  // 工单待处理状态
        System.out.println("init:" + holiday.toString());
        return holiday;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getHldNo() {
        return hldNo;
    }

    public void setHldNo(Long hldNo) {
        this.hldNo = hldNo;
    }

    public Integer getHldEmpNo() {
        return hldEmpNo;
    }

    public void setHldEmpNo(Integer hldEmpNo) {
        this.hldEmpNo = hldEmpNo;
    }

    public Long getHldCreateTime() {
        return hldCreateTime;
    }

    public void setHldCreateTime(Long hldCreateTime) {
        this.hldCreateTime = hldCreateTime;
    }

    public Long getHldStartTime() {
        return hldStartTime;
    }

    public void setHldStartTime(Long hldStartTime) {
        this.hldStartTime = hldStartTime;
    }

    public Long getHldEndTime() {
        return hldEndTime;
    }

    public void setHldEndTime(Long hldEndTime) {
        this.hldEndTime = hldEndTime;
    }

    public Float getHldDays() {
        return hldDays;
    }

    public void setHldDays(Float hldDays) {
        this.hldDays = hldDays;
    }

    public String getHldType() {
        return hldType;
    }

    public void setHldType(String hldType) {
        this.hldType = hldType;
    }

    public String getHldReason() {
        return hldReason;
    }

    public void setHldReason(String hldReason) {
        this.hldReason = hldReason;
    }

    public Integer getHldHandle() {
        return hldHandle;
    }

    public void setHldHandle(Integer hldHandle) {
        this.hldHandle = hldHandle;
    }

    public String getHldHandleName() {
        return hldHandleName;
    }

    public void setHldHandleName(String hldHandleName) {
        this.hldHandleName = hldHandleName;
    }

    public Long getHldHandleTime() {
        return hldHandleTime;
    }

    public void setHldHandleTime(Long hldHandleTime) {
        this.hldHandleTime = hldHandleTime;
    }

    public Float getHldHandleDays() {
        return hldHandleDays;
    }

    public void setHldHandleDays(Float hldHandleDays) {
        this.hldHandleDays = hldHandleDays;
    }

    public String getHldResult() {
        return hldResult;
    }

    public void setHldResult(String hldResult) {
        this.hldResult = hldResult;
    }

    public Integer getHldState() {
        return hldState;
    }

    public void setHldState(Integer hldState) {
        this.hldState = hldState;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }
}