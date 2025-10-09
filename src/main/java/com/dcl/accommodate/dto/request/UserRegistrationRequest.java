package com.dcl.accommodate.dto.request;
//import com.dcl.accommodate.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record UserRegistrationRequest(
        @NotBlank(message = "First name is required")
        @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
        @Pattern(regexp = "^[A-Z][a-zA-Z\\s'-]{1,49}$", message = "Invalid first name format")
        @JsonProperty("first_name")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
        @Pattern(regexp = "^[A-Z][a-zA-Z\\s'-]{0,49}$", message = "Invalid last name format")
        @JsonProperty("last_name")
        String lastName,

        @NotNull(message = "Date of birth is required")
        @JsonProperty("date_of_birth")
        @JsonFormat(pattern = "yyyy-MM-dd" ,shape = JsonFormat.Shape.STRING)
        LocalDate dateOfBirth,

        @NotBlank(message = "Email is required")
        @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email format")
        @JsonProperty("email")
        String email,

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^(?:\\+91\\s)?[6-9]\\d{9}$",
                message = "Phone number must be in a valid format,starting with +91 or 6-9 ")
        @JsonProperty("phone_number")
        String phoneNumber,

        @NotBlank(message = "Password is required")
        @Pattern(
                regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,20}$",
                message = "Password must include uppercase, lowercase, digit, and special character"
        )
        @JsonProperty("password")
        String password



)  {

}