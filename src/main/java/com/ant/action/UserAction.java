package com.ant.action;

import com.ant.exception.DbException;
import com.ant.exception.SqlException;
import com.ant.models.Department;
import com.ant.models.Employee;
import com.ant.models.User;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.server.UserMenageServer;
import com.ant.server.UserServer;
import com.ant.util.Tools;
import org.apache.struts2.ServletActionContext;


public class UserAction extends BaseAction {
    private int id;
    private String userName; // 登录名
    private String userPassword; // 登录密码
    private Integer userType; // 用户类型 1 职员；2顾客；3 系统管理员
    private String userAlias; // 别名（姓名）
    private String userTel; // 电话
    private String userEmail; // 邮箱
    private String userNoteTag; // 备用字段


    private String tip; // 注册页的tip提示用户名是否重复
    private String rePassword; // 修改密码时的新密码


    /**
     * 加载用户信息
     *
     * @return
     */
    public String showPersonInfo() {
        User user = init();
        try {
            user = UserServer.findUser(user);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("user", user);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public String changeInfoAndPsw() {
        // 先修改个人信息

        // 再修改密码

        return SUCCESS;
    }

    /**
     * 修改个人信息
     *
     * @return
     */
    public String changePersonInfo() {
        User user = init();
        System.out.println("user:" + user.toString());
        try {
            // 修改其他信息
            User t3 = UserServer.changeUserInfo(user);
            System.out.println("t3:" + t3.toString());
            // 修改密码
            User t1 = UserServer.changePassword(user, user.getUserNoteTag());
            System.out.println("t1:" + t1.toString());

            // 查询用户
            User u = UserServer.findUser(user);

            getResponseMsgMap().clear();
            getResponseMsgMap().put("user", u);
        } catch (Exception e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }


    /**
     * 修改密码
     * 必备参数：用户名 userName,原始密码 userPassword,新密码 rePassword
     *
     * @return
     */
    public String changePassword() {
        User user = init();
        try {
            user = UserServer.changePassword(user, rePassword);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("user", user);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        } catch (DbException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }


    /**
     * 检查是否重名
     *
     * @return
     */
    public String chechName() {
        try {
            if (!UserServer.checkNameClash(getUserName())) {
                tip = "";
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "Name is not repeated !");
            } else {
                tip = "用户名 " + getUserName() + " 已被注册";
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "Name is repeated !");
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public String register() {
        User user = init();
        user.setUserType(State.USER_YTPE_CUSTOMER); // 表示顾客用户
        try {
            if (!Tools.isEmpty(user.getUserName()) && !Tools.isEmpty(user.getUserPassword())) {
                user = UserServer.register(user);
                getResponseMsgMap().clear();
                // JSONArray jsonArray = JSONArray.fromObject(list);
                getResponseMsgMap().put("user", user);
                // 注册后把 user 放到会话中
                if (user != null) {
                    ServletActionContext.getContext().getSession().put("users", user);
                    System.out.println("~~~~~~~~~~~1:" + user);
                    System.out.println("~~~~~~~~~~~2:" + ServletActionContext.getContext().getSession().get("users"));
                }
            } else {
                getResponseMsgMap().clear();
                getResponseMsgMap().put(Parm.MSG_MEAN, "user init error !");
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        } catch (DbException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    public String loginTest() {
        System.out.println("loginTest");
        if (userName.equals("aa")) {
            ServletActionContext.getContext().getSession().put("userName", userName);
            System.out.println("aa");
        }
        System.out.println("return");
        return SUCCESS;
    }

    public String login() {
        User user = init();
        try {
            if (UserServer.login(user)) {
                user = UserServer.findUser(user);
                getResponseMsgMap().clear();
                getResponseMsgMap().put("users", user);
                // 把user放到会话中
                if (user != null) {
                    ServletActionContext.getContext().getSession().put("users", user);
                    System.out.println("~~~~~~~~~~~1:" + user);
                    System.out.println("~~~~~~~~~~~2:" + ServletActionContext.getContext().getSession().get("users"));
                    // 如果是员工，保存员工emp 和部门 dept
                    if (user.getUserType().equals(State.USER_YTPE_EMPLOYEE)) {
                        keepDept(keepEmp(user));
                    }
                }
                return SUCCESS;
            }
        } catch (DbException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        tip = "用户名或密码错误!";
        return ERROR;
    }

    private void keepDept(Employee emp) throws SqlException {
        Department dept = UserMenageServer.getDept(emp);
        if (dept != null) {
            System.out.println("dept:" + dept.toString());
            ServletActionContext.getContext().getSession().put("dept", dept);
        }
    }

    private Employee keepEmp(User user) throws SqlException {
        Employee emp = UserMenageServer.getEmp(user);
        if (emp != null) {
            System.out.println("emp:" + emp.toString());
            ServletActionContext.getContext().getSession().put("employee", emp);
        }
        return emp;
    }

    private User init() {
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserType(userType);
        user.setUserAlias(userAlias);
        user.setUserTel(userTel);
        user.setUserEmail(userEmail);
        user.setUserNoteTag(userNoteTag);
        System.out.println("init:" + user.toString());
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getUserNoteTag() {
        return userNoteTag;
    }

    public void setUserNoteTag(String userNoteTag) {
        this.userNoteTag = userNoteTag;
    }
}
