package com.access.accountmanagement.account.exception;

import com.access.accountmanagement.account.exception.classes.UserNotFoundException;
import com.access.accountmanagement.common.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {

    private ErrorMessage convertExceptionToCommonErrorMessage(String errorMessageDescription){
        return new ErrorMessage(new Date(), errorMessageDescription);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(convertExceptionToCommonErrorMessage(errorMessageDescription));
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException userNotFoundException){
        String errorMessageDescription = userNotFoundException.getLocalizedMessage();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(convertExceptionToCommonErrorMessage(errorMessageDescription));
    }
}
