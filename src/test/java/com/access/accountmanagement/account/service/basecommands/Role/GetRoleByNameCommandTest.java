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
public class GetRoleByNameCommandTest {
    @Autowired
    CreateRoleInDBCommandImpl saveRoleCommand;

    @Autowired
    GetRoleByNameCommandImpl getRoleByNameCommand;

    @Test
    void GetRoleByNameCommand_ExecuteTest(){
        Role result = getRoleByNameCommand.execute("Common");
        if(result == null){
            Role role = new Role(
                    2L,
                    "Common"
            );
            saveRoleCommand.execute(role);
            result = getRoleByNameCommand.execute("Common");
        }

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L,result.getId());
        Assertions.assertEquals("Common",result.getName());
    }
}
