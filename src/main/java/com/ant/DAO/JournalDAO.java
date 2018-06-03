package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Journal;

import java.util.List;

public interface JournalDAO {
    List<Journal> doFindJournalByEmpNo(Integer empNo) throws SqlException;  // 根据员工号返回日报记录

    List<Journal> doFindJournalByEmpName(String empName) throws SqlException; // 根据员工名返回日报记录
}
