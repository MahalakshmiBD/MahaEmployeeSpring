package com.example.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UserDefinedEmployeeException
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDefinedEmployeeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public UserDefinedEmployeeException(String exception) {
        super(exception);
        this.errorMessage = exception;
      }

  /**
   * @return the errorMessage
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * @param errorMessage the errorMessage to set
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
    
    
}