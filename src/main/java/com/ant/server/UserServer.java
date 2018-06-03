package com.ant.server;

import com.ant.DAOImpl.UserDAOImpl;
import com.ant.exception.DbException;
import com.ant.exception.SqlException;
import com.ant.models.User;
import com.ant.util.Tools;

import javax.tools.Tool;
import java.util.List;

public class UserServer {
    /**
     * 检查用户名是否重复
     *
     * @param name
     * @return
     * @throws SqlException
     */
    public static boolean checkNameClash(String name) throws SqlException {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUserByName(name);
        if (user != null && !user.getUserName().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 检查 Email 是否重复
     *
     * @param email
     * @return
     * @throws SqlException
     */
    public static boolean checkEmailClash(String email) throws SqlException {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUserByEmail(email);
        if (user != null && !user.getUserEmail().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean login(User user) throws SqlException, DbException {
        UserDAOImpl userDAO = new UserDAOImpl();
        user = userDAO.getUserByName(user.getUserName());
        if (user != null) {
            if (user.getUserPassword().equals(user.getUserPassword())) {
                return true;
            } else {
                throw new DbException("User name or password error !");
            }
        }
        return false;
    }

    public static User register(User user) throws SqlException, DbException {
        if (checkNameClash(user.getUserName())) {
            throw new DbException("User name already exists !");
        } else if (checkEmailClash(user.getUserEmail())) {
            throw new DbException("Email has been registed !");
        } else {
            // 插入数据
            UserDAOImpl userDAO = new UserDAOImpl();
            userDAO.doSave(user);
        }
        return user;
    }

    /**
     * 重置密码
     * 必备参数：用户名 userName,原始密码 userPassword,新密码 rePassword
     *
     * @param user
     * @param rePassword
     * @return
     * @throws SqlException
     * @throws DbException
     */
    public static User changePassword(User user, String rePassword) throws SqlException, DbException {
        if (user != null && !Tools.isEmpty(user.getUserName())) {
            UserDAOImpl userDAO = new UserDAOImpl();
            // 获取名字对应的user.id，用于修改密码
            user = userDAO.getUserByNameAndPsw(user);
            System.out.println("user:" + user.toString());
            if (user != null) {
                user = userDAO.updatePasswordById(user, rePassword);
            }
        } else {
            throw new DbException("User is not exists !");
        }
        return user;
    }

    /**
     * 修改密码
     *
     * @param user
     * @return
     * @throws SqlException
     */
    public static User changeUserPsw(User user) throws SqlException {
        // 注意，此时的新密码放在 userNoteTag 中
        if (user != null) {
            // 根据用户名和密码查询是否有用户
            UserDAOImpl userDAO = new UserDAOImpl();
            User t = userDAO.getUserByNameAndPsw(user);
            System.out.println("t:" + t);
            if (t != null) {
                // 重置密码
                user.setId(t.getId());
                userDAO.updatePasswordById(t, user.getUserNoteTag());
            } else {
                System.out.println("用户名或密码错误");
            }
            // 查询用户
            user = userDAO.getUserByName(user.getUserName());
        }
        return user;
    }

    public static User changeUserInfo(User user) throws SqlException {
        if (user != null) {
            // 根据用户名查询用户id
            UserDAOImpl userDAO = new UserDAOImpl();
            User t = userDAO.getUserByName(user.getUserName());
            if (t != null) {
                // 更新信息
                user.setId(t.getId());
                userDAO.changePersonInfoButPsw(user);
            } else {
                System.out.println("没有这个用户");
            }
            // 查询用户
            user = userDAO.getUserByName(user.getUserName());
        }
        return user;
    }


    /**
     * 根据用户名查找用户信息
     *
     * @param user
     * @return
     * @throws SqlException
     */
    public static User findUser(User user) throws SqlException {
        if (user != null) {
            if (!user.getUserName().isEmpty()) {
                UserDAOImpl userDAO = new UserDAOImpl();
                user = userDAO.getUserByName(user.getUserName());
            }
        }
        return user;
    }
}
