package com.dcl.accommodate.controller;

import com.dcl.accommodate.dto.request.UserRegistrationRequest;
import com.dcl.accommodate.dto.wrapper.ApiAck;
import com.dcl.accommodate.exception.UserAlreadyExistsByEmailException;
import com.dcl.accommodate.service.contents.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiAck> registerUser(@RequestBody @Valid UserRegistrationRequest request) throws UserAlreadyExistsByEmailException {
        userService.registerUser(request);
        return ResponseEntity.created(URI.create("/api/v1/profile"))
                .body(new ApiAck(true,"User registered successfully"));
    }
}

