package com.access.accountmanagement.account.service;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.dto.RoleDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AccountmanagementApplication.class)
public class CreateRoleCommandTest {

    @Autowired
    CreateRoleCommandImpl createRoleCommand;

    @Test
    void CreateRoleCommand_InitTest(){
        RoleDto roleDto = new RoleDto(
            1L,
            "Common"
        );

        RoleDto result = createRoleCommand.execute(roleDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L,result.getId());
        Assertions.assertEquals("Common",result.getName());
    }
}
