package com.example.dao;

import com.example.entity.EmployeeDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository  extends JpaRepository<EmployeeDB, Long> {
    
    EmployeeDB findById(int id);
    @Transactional
    int deleteById(int id);
    @Transactional
    <S extends EmployeeDB> S save(EmployeeDB employeeDB);

    
}