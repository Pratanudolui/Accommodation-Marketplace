package com.dcl.accommodate.exception.handler;

import com.dcl.accommodate.dto.wrapper.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArguementNotValid(MethodArgumentNotValidException ex){
        List<FieldError> errors=this.getFieldErrors(ex.getAllErrors());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiErrors(
                false,
                "Invalid input",
                errors
        ));
    }

    private List<FieldError> getFieldErrors(List<ObjectError> errors){
        return errors.stream()
                .map(error-> (org.springframework.validation.FieldError) error)
                .map(fieldError -> new FieldError(
                        fieldError.getField(),
                        fieldError.getRejectedValue(),
                        fieldError.getDefaultMessage()
                )).toList();
    }
}