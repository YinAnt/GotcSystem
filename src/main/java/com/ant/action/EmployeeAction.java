package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Employee;
import com.ant.param.Parm;
import com.ant.server.ContactsServer;
import com.ant.server.UserMenageServer;

import java.util.List;

public class EmployeeAction extends BaseAction{
    private Employee emp;

    /**
     * 加载所有导游信息
     * @return
     */
    public String showAllEmpGuide(){
        try {
            List<Employee> list = UserMenageServer.showAllEmpGuide();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("employee", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 升序加载所有员工信息
     * @return
     */
    public String showContacts(){
        try {
            // 通讯录
            List<Employee> list = ContactsServer.showContacts();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("employee", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public String showAllEmps(){
        try {
            List<Employee> list = UserMenageServer.showAllEmps();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("employee", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
}
