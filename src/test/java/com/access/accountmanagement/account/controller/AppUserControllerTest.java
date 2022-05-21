package com.access.accountmanagement.account.controller;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AccountmanagementApplication.class)
public class AppUserControllerTest {
    private BCryptPasswordEncoder encoder;
    @Autowired
    AppUserController appUserController;

    @BeforeEach
    void setup(){
        encoder = new BCryptPasswordEncoder();
    }

    @Test
    void AppUserController_getAllAppUser_SuccessTest(){
        List<AppUserDto> appUserDtoList = appUserController.getAllAppUser().getBody();
        Assertions.assertNotNull(appUserDtoList);
        if(appUserDtoList.size() == 2){
            Assertions.assertEquals(2, appUserDtoList.size());
        } else {
            Assertions.assertEquals(0, appUserDtoList.size());
        }
    }

    @Test
    void AppUserController_createCommonUser_SuccessTest(){
        String password = "P@ssw0rd";
        CreateUserDto createUserDto = new CreateUserDto(
                null,
                "John1",
                "johnny1994",
                "john1@gmail.com",
                "98765432",
                encoder.encode(password),
                new ArrayList<>()
        );
        ResponseEntity<AppUserDto> result = appUserController.createCommonUser(createUserDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("200 OK",result.getStatusCode().toString());
        Assertions.assertEquals(3L,result.getBody().getId());
        Assertions.assertEquals("John1",result.getBody().getName());
        Assertions.assertEquals("johnny1994",result.getBody().getUsername());
        Assertions.assertEquals("john1@gmail.com",result.getBody().getEmail());
        Assertions.assertEquals("98765432",result.getBody().getContactNumber());
        Assertions.assertEquals(1, result.getBody().getRoleDtos().size());
    }

    @Test
    void AppUserController_createCommonUser_ErrorTest(){
        String password = "P@ssw0rd";
        CreateUserDto createUserDto = new CreateUserDto(
                null,
                "John1",
                "johnny1994",
                "john1@gmail.com",
                "98765432",
                encoder.encode(password),
                new ArrayList<>()
        );
        Assertions.assertThrows(
                Exception.class,
                ()->appUserController.createCommonUser(createUserDto)
        );
    }
}
