package com.ant.DAO;

import com.ant.exception.SqlException;
import com.ant.models.Department;

public interface DepartmentDAO {
    Department getDeptByDeptNo(Integer deptNo) throws SqlException;
}
