package com.ant.server;

import com.ant.DAOImpl.DepartmentDAOImpl;
import com.ant.DAOImpl.EmployeeDAOImpl;
import com.ant.DAOImpl.UserDAOImpl;
import com.ant.exception.SqlException;
import com.ant.models.Department;
import com.ant.models.Employee;
import com.ant.models.User;

import java.util.List;

public class UserMenageServer {
    public static List<Employee> showAllEmpGuide() throws SqlException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        List<Employee> list = employeeDAO.findAllEmpGuide();
        return list;
    }

    public static List<Employee> showAllEmps() throws SqlException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        List<Employee> list = employeeDAO.findAllForContactByIdAsc();
        return list;
    }

    public static List<Department> showAllDepts() throws SqlException {
        DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();
        List<Department> list = departmentDAO.doFindAll();
        return list;
    }

    public static Employee getEmp(User user)throws SqlException {
        UserDAOImpl userDAO = new UserDAOImpl();
        user = userDAO.getUserByName(user.getUserName());
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        Employee emp = employeeDAO.getEmpByEmpName(user.getUserAlias());    // 通过用户别名（员工名）查找
        return emp;
    }

    public static Department getDept(Employee emp)throws SqlException {
        DepartmentDAOImpl departmentDAO = new DepartmentDAOImpl();
        Department dept = departmentDAO.getDeptByDeptNo(emp.getEmpDeptNo());    // 通过用户别名（员工名）查找
        return dept;
    }
}
