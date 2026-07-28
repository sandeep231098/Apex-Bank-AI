package com.apexbank.account.dto.request;

import com.apexbank.common.enums.AccountStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountRequest {

    @NotNull
    private AccountStatus status;
}