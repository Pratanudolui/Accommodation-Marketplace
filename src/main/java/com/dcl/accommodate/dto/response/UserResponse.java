package com.dcl.accommodate.dto.response;

import com.dcl.accommodate.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserResponse {
    private UUID userId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private List<UserRole> roles;
    private String avatar;
    private Instant createdAt;
    private Instant lastUpdatedAt;
}
