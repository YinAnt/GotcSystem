package com.ant.server;

import com.ant.DAOImpl.EmployeeDAOImpl;
import com.ant.exception.SqlException;
import com.ant.models.Employee;

import java.util.List;

public class ContactsServer {
    public static List<Employee> showContacts() throws SqlException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        List<Employee> list = employeeDAO.findAllForContactByIdAsc();
        return list;
    }
}
