package com.access.accountmanagement.account.controller;

import com.access.accountmanagement.account.dto.RoleDto;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import com.access.accountmanagement.account.exception.classes.UserNotFoundException;
import com.access.accountmanagement.account.service.CreateUserCommand;
import com.access.accountmanagement.account.service.FindAllAppUserCommand;
import com.access.accountmanagement.account.service.GetRoleDtoByNameCommand;
import com.access.accountmanagement.common.constants.AccountConstants;
import com.access.accountmanagement.common.enums.ApplicationUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/appuser")
@RequiredArgsConstructor
public class AppUserController {

    private final CreateUserCommand createUserCommand;
    private final FindAllAppUserCommand findAllAppUserCommand;
    private final GetRoleDtoByNameCommand getRoleDtoByNameCommand;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/common")
    public ResponseEntity<AppUserDto> createCommonUser(@Valid @RequestBody CreateUserDto createUserDto){
        try{
            RoleDto roleDto = getRoleDtoByNameCommand.execute(ApplicationUserRole.COMMON_USER.name());
            createUserDto.setRoleDtos(Arrays.asList(roleDto));
            createUserDto.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
            AppUserDto result = createUserCommand.execute(createUserDto);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch(Exception e) {
            throw e;
        }
    }

    @GetMapping("/")
//    @RolesAllowed(AccountConstants.ADMIN_ROLE)
    public ResponseEntity<List<AppUserDto>> getAllAppUser() throws UserNotFoundException {
        List<AppUserDto> result = findAllAppUserCommand.execute();
        if(result.size()>0){
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        throw new UserNotFoundException(
            "There are no user in database"
        );
    }

//    @GetMapping("/{username}")


}
