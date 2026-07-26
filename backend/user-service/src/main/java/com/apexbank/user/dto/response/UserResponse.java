package com.apexbank.user.dto.response;

import com.apexbank.common.enums.Gender;
import com.apexbank.common.enums.KycStatus;
import com.apexbank.common.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponse {

    private UUID id;

    private String keycloakId;

    private String email;

    private String firstName;

    private String lastName;

    private String phone;

    private Gender gender;

    private UserStatus status;

    private KycStatus kycStatus;
}