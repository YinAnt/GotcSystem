package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Journal;
import com.ant.param.Parm;
import com.ant.server.AttendanceServer;
import com.ant.util.Tools;

import javax.tools.Tool;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JournalAction extends BaseAction{
    private Long jnlNo; //工单号
    private Integer jnlEmpNo;   // 工号
    private String jnlEmpName;  // 姓名
    private Long jnlCreateTime; // 日报对应的日期，因为可以补填日报，所以该字段并非真正的创建时间
    private String jnlContent;  // 日报内容
    private String jnlDutyType; // 值班类型 ：在岗、2 请假、3 出差

    private Integer uEmpNo = 1002;

    private String timeStr;

    /**
     * 填写日报
     * @return
     */
    public String addJournal(){
        System.out.println("----------------addJournal----------------");
        Journal journal = init();
        try {
            journal = AttendanceServer.addJounal(journal);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("journal", journal);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载所有人的日报
     * @return
     */
    public String showAllJournal(){
        try {
            List<Journal> list = AttendanceServer.showAllJournal();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("journal", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载某人的日报
     * @return
     */
    public String showMyJournal(){
        Journal journal = new Journal();
        journal.setJnlEmpName(jnlEmpName);
        journal.setJnlEmpNo(jnlEmpNo);
        if (jnlEmpNo == null){
            journal.setJnlEmpNo(uEmpNo);
        }
        try {
            List<Journal> list = AttendanceServer.showMyAllJournal(journal);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("journal", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public Journal init(){

        // 日期处理
        System.out.println("timeStr:" + timeStr);
        if (timeStr !=null) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(timeStr);
                // 验证date
                System.out.println("date:"+date.toString());
                // 验证日期
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("date format:" + dateFormat2.format(date));
                // 毫秒数
                System.out.println("date.getTime():"+date.getTime());

                jnlCreateTime = date.getTime();

            } catch (Exception e) {
                System.out.println("date error:");
                e.printStackTrace();
            }
//        System.out.println("-----------------------------------------------:");
        }


        Journal journal = new Journal();
        journal.setJnlNo(System.currentTimeMillis());
        journal.setJnlEmpNo(jnlEmpNo);
        journal.setJnlEmpName(jnlEmpName);
        journal.setJnlCreateTime(jnlCreateTime);    // 日报对应的日期，因为可以补填日报，所以该字段并非真正的创建时间
        journal.setJnlContent(getJnlContent());
        journal.setJnlDutyType(jnlDutyType);
        System.out.println("init:"+journal.toString());
        return journal;
    }


    public Long getJnlNo() {
        return jnlNo;
    }

    public void setJnlNo(Long jnlNo) {
        this.jnlNo = jnlNo;
    }

    public Integer getJnlEmpNo() {
        return jnlEmpNo;
    }

    public void setJnlEmpNo(Integer jnlEmpNo) {
        this.jnlEmpNo = jnlEmpNo;
    }

    public String getJnlEmpName() {
        return jnlEmpName;
    }

    public void setJnlEmpName(String jnlEmpName) {
        this.jnlEmpName = jnlEmpName;
    }

    public Long getJnlCreateTime() {
        return jnlCreateTime;
    }

    public void setJnlCreateTime(Long jnlCreateTime) {
        this.jnlCreateTime = jnlCreateTime;
    }

    public String getJnlContent() {
        return jnlContent;
    }

    public void setJnlContent(String jnlContent) {
        this.jnlContent = jnlContent;
    }

    public String getJnlDutyType() {
        return jnlDutyType;
    }

    public void setJnlDutyType(String jnlDutyType) {
        this.jnlDutyType = jnlDutyType;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }
}
