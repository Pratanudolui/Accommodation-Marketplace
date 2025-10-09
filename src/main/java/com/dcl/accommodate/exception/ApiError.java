package com.dcl.accommodate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {
    private String rejectedField;
    private Object rejectedValue;
    private String message;
}
