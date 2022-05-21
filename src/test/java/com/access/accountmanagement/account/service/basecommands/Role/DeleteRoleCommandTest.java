package com.access.accountmanagement.account.service.basecommands.Role;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.domain.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AccountmanagementApplication.class)
public class DeleteRoleCommandTest {
    @Autowired
    DeleteRoleCommandImpl deleteRoleCommand;

    @Test
    void DeleteRoleCommand_ExecuteTest(){
        Role role = new Role(
            1L,
            "Common"
        );
        deleteRoleCommand.execute(role);
    }
}
