package com.example.demo;

import com.example.entity.EmployeeDB;
import com.example.service.EmployeeService;
import com.example.util.EmployeeUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the controller class which will have all the endpoint implementation
 * for Employee data management
 * author : mahalakshmi
 */

@SpringBootApplication
@RestController
@EnableJpaRepositories("com.example*")
@CrossOrigin(origins = "http://localhost:4200")
@EntityScan("com.example*")
@ComponentScan("com.example*")

public class DemoApplication {

  @Autowired
  private EmployeeService employeeService;
  
   /**
    * This method takes id as the input and fetches employee object for the from DB and returns
    the same to the service call
    * @param id
    * @return
    */
   @RequestMapping(value = "/readEmployee/{id}")
   public ResponseEntity<Object> readEmployee(@PathVariable("id") String id) {
      Employee resultEmp = new Employee();
      if(EmployeeUtil.checkValidID(id)){
         try{
            EmployeeDB empDB = employeeService.readEmployee(id);
            resultEmp = EmployeeUtil.convertOneDBObject(empDB);
            if(EmployeeUtil.checkStringNotNull(resultEmp.getFirstName())){
               resultEmp.setMessage("Employee Data read successfully");         
            }else{
               resultEmp.setId(Integer.parseInt(id.trim()));
               resultEmp.setMessage("Employee Data not found for Id");
            }
         }catch(Exception e){
            resultEmp.setMessage("Error while getting employee records");
         }
      }else{
         resultEmp.setMessage("Invalid Employee Id, Enter a numeric value");
      }
      return new ResponseEntity<>(resultEmp, HttpStatus.OK);
   }

   /**
    * 
    * @param employee
    * @return
    */
   @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
   public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
      EmployeeDB empDB = EmployeeUtil.getDBObject(employee); 
      EmployeeDB createdEmpDB = new EmployeeDB(); 
      Employee createdEmp = new Employee();
     try{ 
         createdEmpDB = employeeService.saveEmployee(empDB);
         createdEmp = EmployeeUtil.convertOneDBObject(createdEmpDB);
         createdEmp.setMessage("Employee record is created successfully");
     }catch(Exception e){
         createdEmp.setMessage("Error while trying to save Employee records");     
       }       
      return new ResponseEntity<>(createdEmp, HttpStatus.CREATED);
   }

   /**
    * 
    * @param id
    * @param employee
    * @return
    */
   @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) { 
      EmployeeDB empDB = EmployeeUtil.getDBObject(employee);
      Employee updatedEmp = new Employee();
         try{
            EmployeeDB updatedEmpDB = employeeService.updEmployeeDB(id, empDB);
            updatedEmp = EmployeeUtil.convertOneDBObject(updatedEmpDB);
            if(EmployeeUtil.checkStringNotNull(updatedEmp.getFirstName())){
               updatedEmp.setMessage("Employee data updated successsfully");
            }else{
               updatedEmp.setId(Integer.parseInt(id));
               updatedEmp.setMessage("Unable to update Employee Data");
            }
         }catch(Exception e){
            updatedEmp.setMessage("Unable to update Employee Data");
         }
 	  return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
   }

   /**
    *    
    */
   @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      Employee deletedEmp = new Employee();
      deletedEmp.setId(Integer.parseInt(id.trim()));
      try{
         int result = employeeService.deleteEmp(id);     
         if (result == 1){
          deletedEmp.setMessage("Employee Informations is deleted successsfully");         
         }else{
            deletedEmp.setMessage("Unable to delete Employee Information");
         }
      }catch(Exception e){
         deletedEmp.setMessage("Unable to delete Employee Information");
      }
      return new ResponseEntity<>(deletedEmp, HttpStatus.OK);
   }

   

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

   
   @GetMapping("/employees")
   public ResponseEntity<Object> allEmployees() {
      return new ResponseEntity<>
                   (EmployeeUtil.convertDBObjects(employeeService.getAllEmployee()), HttpStatus.OK);     
   }
}
