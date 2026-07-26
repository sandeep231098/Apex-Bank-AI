package com.apexbank.account.dto.request;

import com.apexbank.common.enums.AccountStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountRequest {

    private AccountStatus accountStatus;

    @NotBlank(message = "Branch code is required")
    private String branchCode;

    @NotBlank(message = "IFSC code is required")
    private String ifscCode;
}