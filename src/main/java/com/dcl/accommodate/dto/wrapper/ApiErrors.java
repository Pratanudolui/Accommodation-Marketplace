package com.dcl.accommodate.dto.wrapper;

import org.springframework.validation.FieldError;

import java.util.List;

public record ApiErrors(
        boolean success,
        String message,
        List<FieldError> errors
)
{
        }
