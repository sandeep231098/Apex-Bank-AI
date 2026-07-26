package com.apexbank.user.dto.request;

import com.apexbank.common.enums.Gender;
import lombok.Data;

@Data
public class UpdateUserRequest {

    private String firstName;

    private String lastName;

    private String phone;

    private Gender gender;
}