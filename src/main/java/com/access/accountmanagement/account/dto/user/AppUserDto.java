package com.access.accountmanagement.account.dto.user;

import com.access.accountmanagement.account.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String contactNumber;

    private List<RoleDto> roleDtos;
}
