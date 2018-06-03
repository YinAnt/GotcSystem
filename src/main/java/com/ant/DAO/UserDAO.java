package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.User;

import java.util.List;

public interface UserDAO {
    User getUserByEmail(String email) throws SqlException;

    User getUserByName(String name) throws SqlException;

    User getUserByNameAndPsw(User user) throws SqlException;

    // 重置密码
    User updatePasswordById(User user, String userPassword) throws SqlException;

    User changePersonInfoButPsw(User user)throws SqlException;

}
