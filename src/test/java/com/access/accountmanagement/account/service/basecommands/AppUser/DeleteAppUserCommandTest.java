package com.access.accountmanagement.account.service.basecommands.AppUser;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.service.basecommands.Role.DeleteRoleCommandImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AccountmanagementApplication.class)
public class DeleteAppUserCommandTest {

    private BCryptPasswordEncoder encoder;
    @Autowired
    DeleteAppUserCommandImpl deleteAppUserCommand;

    @BeforeEach
    void setup(){
        encoder = new BCryptPasswordEncoder();
    }

    @Test
    void DeleteAppUserCommand_ExecuteTest(){
        String password = "P@ssw0rd";
        AppUser appUser = new AppUser(
                2L,
                "John",
                "johnny94",
                "john@gmail.com",
                "98765432",
                encoder.encode(password),
                new ArrayList<>()
        );
        deleteAppUserCommand.execute(appUser);
    }
}
