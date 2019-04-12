package com.example.exception;



/**
 * ErrorDetails
 */
public class ErrorDetails {

    private String errorMessage;
    private int errorCode;

    public ErrorDetails(String errMsg, int errCode){
      this.errorMessage =errMsg;
      this.errorCode = errCode;
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
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
  

	
    
}