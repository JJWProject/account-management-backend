package com.access.accountmanagement.account.controller;

import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import com.access.accountmanagement.account.service.CreateUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/appuser")
@RequiredArgsConstructor
public class AppUserController {

    private final CreateUserCommand createUserCommand;

    @PostMapping("/common")
    public ResponseEntity<AppUserDto> createCommonUser(@Valid CreateUserDto createUserDto){
        try{
            AppUserDto result = createUserCommand.execute(createUserDto);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch(Exception e) {
            throw e;
        }
    }

}
