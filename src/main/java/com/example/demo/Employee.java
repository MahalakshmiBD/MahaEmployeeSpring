package com.example.demo;

import java.util.Date;

/**
 * This is a pojo class to store the employee details
 * author: Mahalakshmi
 */

public class Employee {
   private int id;
   private String firstName;
   private String surname;      
   private String email;
   private Date dob;
   private String gender;
   private String message;
   
   /**
    * @return the id
    */

   
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
    * @return the surname
    */
   public String getSurname() {
      return surname;
   }

   /**
    * @param surname the surname to set
    */
   public void setSurname(String surname) {
      this.surname = surname;
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

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((dob == null) ? 0 : dob.hashCode());
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
      result = prime * result + ((gender == null) ? 0 : gender.hashCode());
      result = prime * result + id;
      result = prime * result + ((surname == null) ? 0 : surname.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Employee other = (Employee) obj;
      if (dob == null) {
         if (other.dob != null)
            return false;
      } else if (!dob.equals(other.dob))
         return false;
      if (email == null) {
         if (other.email != null)
            return false;
      } else if (!email.equals(other.email))
         return false;
      if (firstName == null) {
         if (other.firstName != null)
            return false;
      } else if (!firstName.equals(other.firstName))
         return false;
      if (gender == null) {
         if (other.gender != null)
            return false;
      } else if (!gender.equals(other.gender))
         return false;
      if (id != other.id)
         return false;
      if (surname == null) {
         if (other.surname != null)
            return false;
      } else if (!surname.equals(other.surname))
         return false;
      return true;
   }

   /**
    * @return the message
    */
   public String getMessage() {
      return message;
   }

   /**
    * @param message the message to set
    */
   public void setMessage(String message) {
      this.message = message;
   }

   
}