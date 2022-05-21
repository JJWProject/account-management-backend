package com.access.accountmanagement.account.controller;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.dto.RoleDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AccountmanagementApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoleControllerTest {
    @Autowired
    RoleController roleController;

    @Test
    @Order(1)
    void RoleController_createRole_SuccessTest(){
        RoleDto roleDto = new RoleDto(
            1L,
            "Common"
        );
        ResponseEntity<RoleDto> result = roleController.createRole(roleDto);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("200 OK",result.getStatusCode().toString());
        Assertions.assertEquals("Common",result.getBody().getName());
    }

    @Test
    @Order(2)
    void RoleController_createRole_ErrorTest(){
        RoleDto roleDto = new RoleDto(
                null,
                "Common"
        );
        Assertions.assertThrows(
            Exception.class,
            ()->roleController.createRole(roleDto)
        );
    }
}
