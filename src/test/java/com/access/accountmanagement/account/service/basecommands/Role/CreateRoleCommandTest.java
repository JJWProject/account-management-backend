package com.access.accountmanagement.account.service.basecommands.Role;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.domain.Role;
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
    CreateRoleInDBCommandImpl saveRoleCommand;

    @Test
    void SaveRoleCommand_ExecuteTest(){
        Role role = new Role(
            null,
            "Common"
        );

        Role result = saveRoleCommand.execute(role);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L,result.getId());
        Assertions.assertEquals("Common",result.getName());
    }
}
