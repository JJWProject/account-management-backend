package com.access.accountmanagement.account.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDto {
    private Long id;

    @NotBlank(message = "Role name must not be blank")
    private String name;
}
