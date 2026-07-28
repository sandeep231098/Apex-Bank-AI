package com.apexbank.auth.dto.response;

import com.apexbank.auth.entity.Role;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private Role role;
}