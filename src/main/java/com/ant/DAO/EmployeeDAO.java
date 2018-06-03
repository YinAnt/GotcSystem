package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAllForContactByIdAsc() throws SqlException;

    Employee getEmpByEmpName(String empName) throws SqlException;

    Employee getEmpByEmpNo(Integer empNo) throws SqlException;

    List<Employee> findAllEmpGuide() throws SqlException;   // 加载所有导游信息
}
