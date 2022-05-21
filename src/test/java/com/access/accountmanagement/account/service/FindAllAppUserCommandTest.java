package com.access.accountmanagement.account.service;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AccountmanagementApplication.class)
public class FindAllAppUserCommandTest {
    @Autowired
    FindAllAppUserCommandImpl findAllAppUserCommand;

    @Test
    void FindAllAppUserCommand_ExecuteTest(){
        String password = "P@ssw0rd";
        List<AppUserDto> result = findAllAppUserCommand.execute();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }
}
