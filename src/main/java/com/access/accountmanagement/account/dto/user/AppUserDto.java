package com.access.accountmanagement.account.dto.user;

import com.access.accountmanagement.account.dto.RoleDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUserDto {
    private Long id;
    private String name;
    private String userName;
    private String email;
    private String contactNumber;

    private List<RoleDto> roleDtos;
}
