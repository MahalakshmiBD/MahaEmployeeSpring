package com.example.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * ExceptionControllerAdvice
 */
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler{

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<ErrorDetails> exceptionHandler(Exception ex) {
    //     ErrorDetails error = new ErrorDetails
    //     ("Please contact your administrator", HttpStatus.INTERNAL_SERVER_ERROR.value());    
    //     return new ResponseEntity<ErrorDetails>(error, HttpStatus.OK);
    // }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails
            ("Please contact your administrator", HttpStatus.INTERNAL_SERVER_ERROR.value());    
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    

     @ExceptionHandler(UserDefinedEmployeeException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex,  WebRequest request) {
      ErrorDetails error = new ErrorDetails(ex.getMessage(),HttpStatus.PRECONDITION_FAILED.value());
     return new ResponseEntity<ErrorDetails>(error, HttpStatus.PRECONDITION_FAILED);
    }

   
}