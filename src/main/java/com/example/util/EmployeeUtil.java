package com.example.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.demo.Employee;
import com.example.entity.EmployeeDB;

/**
 * EmployeeUtil
 */
public class EmployeeUtil {

    public static List<Employee> convertDBObjects(List<EmployeeDB> fromDatabase) {

        List<Employee> empList = new ArrayList<>();
        if (fromDatabase != null && fromDatabase.size() > 0) {
            Iterator<EmployeeDB> employeeDBIterator = fromDatabase.iterator();
            if (employeeDBIterator != null) {
                while (employeeDBIterator.hasNext()) {
                    EmployeeDB empDB = employeeDBIterator.next();
                    Employee emp = new Employee();
                    emp.setId(empDB.getId());
                    emp.setFirstName(empDB.getFirstName());
                    emp.setSurname(empDB.getSurName());
                    emp.setGender(empDB.getGender());
                    emp.setEmail(empDB.getEmail());
                    emp.setDob(empDB.getDob());
                    empList.add(emp);
                }
            }
        }
        return empList;
    }

    public static Employee convertOneDBObject(EmployeeDB fromDatabase) {
        Employee emp = new Employee();
        if (fromDatabase != null) {
            emp.setId(fromDatabase.getId());
            emp.setFirstName(fromDatabase.getFirstName());
            emp.setSurname(fromDatabase.getSurName());
            emp.setGender(fromDatabase.getGender());
            emp.setEmail(fromDatabase.getEmail());
            emp.setDob(fromDatabase.getDob());
        }
        return emp;
    }

    public static EmployeeDB getDBObject(Employee employee) {
        EmployeeDB empDB = null;
        if (employee != null) {
            empDB = new EmployeeDB();
            empDB.setId(employee.getId());
            empDB.setFirstName(employee.getFirstName());
            empDB.setSurName(employee.getSurname());
            empDB.setGender(employee.getGender());
            empDB.setEmail(employee.getEmail());
            empDB.setDob(utilToSqlDate(employee.getDob()));
        } 
		return empDB;
	}
  
    public static Date utilToSqlDate(java.util.Date utilDate){
        if(utilDate!= null){
        return new Date(utilDate.getTime());
        } else{
            return null;
        }
    }

	public static boolean checkStringNotNull(String str) {
		return str != null && !str.isEmpty();
	}

	public static boolean checkValidID(String id) {
        if(id == null || id.isEmpty() || id.equalsIgnoreCase("".trim()) ){
            return false;
        }else{
            int i = 0;
            int length = id.length();
            if (id.charAt(0) == '-') {
                if (length == 1) {
                    return false;
                }
                i = 1;
            }
            for (; i < length; i++) {
                char c = id.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;        
        }
    }
    

}