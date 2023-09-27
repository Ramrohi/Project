package com.Netinsight.Netinsight.Exception;

public class ServiceException extends RuntimeException {
	   ExceptionDetails exceptionDetails;

	    public ServiceException()
	    {

	    }
	    public ServiceException(String message, ExceptionDetails exceptionDetails) {
	        super(message);
	        this.exceptionDetails = exceptionDetails;
	    }

}
