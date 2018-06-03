package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Signin;

import java.util.List;

public interface SigninDAO {
    List<Signin> doFindAllByEmpNo(Integer signEmpNo) throws SqlException; // 查询一个人的全部签到、签退记录

    Signin doFindByEmpAndSignDay(Integer signEmpNo, Long lDays) throws SqlException; // 查询一个人当天的签到记录

    List<Signin> doFindAllSignInByEmpNo(Integer signEmpNo) throws SqlException; // 查询一个人的全部签到记录

    List<Signin> doFindAllSignOutByEmpNo(Integer signEmpNo) throws SqlException; // 查询一个人的全部签退记录

    List<Signin> doFindMonthSignOutByEmpNo(Integer signEmpNo) throws SqlException; // 查询一个人 当月的 签退记录
}
