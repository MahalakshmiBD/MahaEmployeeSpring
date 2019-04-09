package com.example.entity;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;



import lombok.Data;

/**
 * EmployeeDB
 */
@Data
@Entity
@Table(name= "employee")

public class EmployeeDB {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="emp_id")    
    private  int id;

    @Column(name="emp_first_Nm")
    @NotEmpty(message="* Please Enter FirstName")
    private String firstName;

    @Column(name="emp_sur_Nm")
    @NotEmpty(message="* Please Enter SurName")
    private String surName;

    @Email(message="* Please Enter Valid Email Address")
    @Column(name="emp_email")
    private String email;


    @Column(name="emp_gender")
    @NotEmpty(message="* Please Enter Valid gender ")
    private String gender;

    @Column(name="emp_DOB")
    private Date dob;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the surName
     */
    public String getSurName() {
        return surName;
    }

    /**
     * @param surName the surName to set
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    
}