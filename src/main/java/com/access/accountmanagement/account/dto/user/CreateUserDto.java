package com.access.accountmanagement.account.dto.user;

import com.access.accountmanagement.account.dto.RoleDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUserDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Username is mandatory")
    private String userName;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Contact Number is mandatory")
    private String contactNumber;
    @NotBlank(message = "Password is mandatory")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "Password must be at least 8 characters, at least one uppercase letter, one lowercase letter, one number and one special character"
    )
    private String password;

    private List<RoleDto> roleDtos;
}
