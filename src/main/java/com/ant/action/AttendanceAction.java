package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Employee;
import com.ant.models.Signin;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.server.AttendanceServer;
import com.ant.util.Tools;
import org.apache.struts2.ServletActionContext;
import org.hibernate.dialect.SybaseAnywhereDialect;

import java.util.ArrayList;
import java.util.List;


public class AttendanceAction extends BaseAction {
    private int id;
    // signIn
    private Integer signEmpNo; // 员工号
    private String signEmpName; // 员工名
    private Long signDay; // 签到日期
    private Long signInTime; // 签到时间
    private String signInIp;    // 签到IP
    private Long signOutTime; // 签退时间
    private String signOutIp; // 签退IP
    private Integer signFlag; // 签到类型

    /**
     * 统计某人的考勤信息
     *
     * @return
     */
    public String calMyAttendance() {
        System.out.println("calMyAttendance");
        Signin signin = initSignIn();
        try {
            int todayCnt = 0, signInCnt = 0, signOutCnt = 0, journalCnt = 0;
            float leaveDays = 0;
            todayCnt = Tools.getMonthDay();
            // 请假天数
            leaveDays = AttendanceServer.calNowLeaveDays(signin.getSignEmpNo());
            // 签到次数
            signInCnt = AttendanceServer.calNowSignInCnt(signin.getSignEmpNo());
            // 签退次数
            signOutCnt = AttendanceServer.calNowSignOutCnt(signin.getSignEmpNo());
            // 日记填写次数
            journalCnt = AttendanceServer.calNowJournalCnt(signin.getSignEmpNo());

            getResponseMsgMap().clear();
            getResponseMsgMap().put("todayCnt", todayCnt);
            getResponseMsgMap().put("leaveDaysCnt", leaveDays);
            getResponseMsgMap().put("signInCnt", signInCnt);
            getResponseMsgMap().put("signOutCnt", signOutCnt);
            getResponseMsgMap().put("journalCnt", journalCnt);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }


    /**
     * 签到
     *
     * @return
     */
    public String signIn() {
        System.out.println("sign");
        Signin signin = initSignIn();
        try {
            signin = AttendanceServer.signIn(signin);
            System.out.println("action:" + signin.toString());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("sign", signin);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 获取所有人的签到记录
     *
     * @return
     */
    public String showAllSignIn() {
        List<Signin> list = new ArrayList<>();
        try {
            list = AttendanceServer.showAllSignIn();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("sign", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 获取个人的所有签到记录
     * 注意：emp_no
     *
     * @return
     */
    public String showMyAllSignIn() {
        System.out.println("showMyAllSignIn");
        Signin signin = initSignIn();
        signin.setSignEmpNo(1002);
        try {
            List<Signin> list = AttendanceServer.showAllSignInByEmpNo(signin.getSignEmpNo());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("sign", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 获取个人 当月 所有的签到记录
     * 注意：emp_no
     *
     * @return
     */
    public String showMyMonthSignIn() {
        Signin signin = initSignIn();
        signin.setSignEmpNo(1002);
        System.out.println("1signin:"+signin.getSignEmpNo());
        try {
            List<Signin> list = AttendanceServer.showMonthSignInByEmpNo(signin.getSignEmpNo());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("sign", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    private Signin initSignIn() {
        Signin s = new Signin();
        s.setSignEmpNo(signEmpNo);
        s.setSignEmpName(signEmpName);
        s.setSignDay(System.currentTimeMillis());
        s.setSignFlag(State.SIGN_FLAG_IN);  // 默认为签到
        s.setSignFlag(signFlag);
        s.setSignInTime(System.currentTimeMillis());
        s.setSignInIp(ServletActionContext.getRequest().getRemoteAddr());   // 请求
        System.out.println("init:" + s.toString());
        return s;
    }

    public Integer getSignEmpNo() {
        return signEmpNo;
    }

    public void setSignEmpNo(Integer signEmpNo) {
        this.signEmpNo = signEmpNo;
    }

    public Long getSignDay() {
        return signDay;
    }

    public void setSignDay(Long signDay) {
        this.signDay = signDay;
    }

    public Long getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Long signInTime) {
        this.signInTime = signInTime;
    }

    public String getSignInIp() {
        return signInIp;
    }

    public void setSignInIp(String signInIp) {
        this.signInIp = signInIp;
    }

    public Long getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(Long signOutTime) {
        this.signOutTime = signOutTime;
    }

    public String getSignOutIp() {
        return signOutIp;
    }

    public void setSignOutIp(String signOutIp) {
        this.signOutIp = signOutIp;
    }

    public Integer getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }

    public String getSignEmpName() {
        return signEmpName;
    }

    public void setSignEmpName(String signEmpName) {
        this.signEmpName = signEmpName;
    }
}
