package com.access.accountmanagement.account.controller;

import com.access.accountmanagement.account.dto.RoleDto;
import com.access.accountmanagement.account.mapper.RoleMapper;
import com.access.accountmanagement.account.service.CreateRoleCommand;
import com.access.accountmanagement.common.enums.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import static com.access.accountmanagement.common.enums.ApplicationUserRole.*;

@RestController
@RequestMapping("api/role")
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private CreateRoleCommand createRoleCommand;

    @PostMapping("/")
//    @RolesAllowed(ApplicationUserRole.ADMIN)
    public ResponseEntity<RoleDto> createRole(@Valid @RequestBody RoleDto roleDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(createRoleCommand.execute(roleDto));
        }catch(Exception e){
            throw e;
        }
    }

}
