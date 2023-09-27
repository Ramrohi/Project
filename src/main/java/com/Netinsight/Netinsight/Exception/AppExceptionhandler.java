package com.Netinsight.Netinsight.Exception;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppExceptionhandler {
    Logger logger = LoggerFactory.getLogger(AppExceptionhandler.class);
    
    public void raiseException(String errorMessage) {
        logger.error("Exception thrown with error message: {}", errorMessage);
        String exceptionId = String.valueOf(Instant.now());
        ExceptionDetails exceptionDetails = new ExceptionDetails(exceptionId, errorMessage);
        throw new ServiceException(errorMessage, exceptionDetails);
    }
    

   /* @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public static class UnauthorizedException extends RuntimeException {
        public UnauthorizedException(String message) {
            super(message);
        }
        */
    }


