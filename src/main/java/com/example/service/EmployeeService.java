package com.example.service;

import java.util.List;

import com.example.dao.EmployeeRepository;
import com.example.entity.EmployeeDB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeService
 */
@Service("employeeService")
public class EmployeeService {
    @Autowired
   private EmployeeRepository employeeRepository;

   public List<EmployeeDB> getAllEmployee() {
    return employeeRepository.findAll();
    
}

public EmployeeDB saveEmployee(EmployeeDB employee) {
    return employeeRepository.save(employee);
}

public EmployeeDB readEmployee(String id) {
    int empId=  Integer.parseInt(id.trim());    
    return employeeRepository.findById(empId);
}

public EmployeeDB updEmployeeDB(String id, EmployeeDB employee) {
    EmployeeDB empDb =new EmployeeDB();    
    
        int empId=  Integer.parseInt(id.trim());
        empDb =employeeRepository.findById(empId);
        if (empDb != null){
            empDb.setDob(employee.getDob());
            empDb.setEmail(employee.getEmail());
            empDb.setFirstName(employee.getFirstName());
            empDb.setGender(employee.getGender());
            empDb.setSurName(employee.getSurName());
            return  employeeRepository.save(empDb);
        }else{
            return empDb;
        }
        
}

public int deleteEmp(String id) {
        int empId=Integer.parseInt(id);
    return employeeRepository.deleteById(empId);
}



    
}