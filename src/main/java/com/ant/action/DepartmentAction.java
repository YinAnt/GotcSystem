package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Department;
import com.ant.param.Parm;
import com.ant.server.UserMenageServer;

import java.util.List;

public class DepartmentAction extends BaseAction{

    private int deptNo;
    private String deptName;
    private Integer deptLeader;

    public String showDepts(){
        try {
            List<Department> list = UserMenageServer.showAllDepts();
            if (list != null && !list.isEmpty()) {
                getResponseMsgMap().clear();
                getResponseMsgMap().put("department", list);
            } else {
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "No department !");
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptLeader() {
        return deptLeader;
    }

    public void setDeptLeader(Integer deptLeader) {
        this.deptLeader = deptLeader;
    }
}
