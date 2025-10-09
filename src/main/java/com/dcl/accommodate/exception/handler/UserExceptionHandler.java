package com.dcl.accommodate.exception.handler;

import com.dcl.accommodate.dto.wrapper.ApiAck;
import com.dcl.accommodate.exception.UserAlreadyExistsByEmailException;
//import com.dcl.accommodate.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsByEmailException.class)
    public ResponseEntity<ApiAck> handleUserAlreadyExistsByEmail(UserAlreadyExistsByEmailException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiAck(false,ex.getMessage()));

    }
}