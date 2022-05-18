package com.access.accountmanagement.account.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChangePwDto {
    private String userName;
    private String oldPassword;
    private String newPassword;
}
