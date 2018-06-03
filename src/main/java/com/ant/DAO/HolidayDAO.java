package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Holiday;

import java.util.List;

public interface HolidayDAO {
    List<Holiday> doFindAllByEmpNo(Integer hldEmpNo) throws SqlException; // 查询一个人全部请假的记录

    List<Holiday> dofindMyHandleHolidayByEmpNo(String  hldHandleName) throws SqlException; // 根据处理人查询所有的请假的记录

    List<Holiday> dofindWaitForMyHandleHolidayByEmpNo(String  hldHandleName) throws SqlException; // 根据处理人查询所有待处理的请假的记录

    Holiday doFindByHldNo(Long hldNo) throws SqlException; // 根据工单号查询一条记录

    List<Holiday> doFindMonthByEmpNo(Integer hldEmpNo) throws SqlException; // 查询一个人当月请假的记录
}
