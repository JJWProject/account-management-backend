package com.access.accountmanagement.account.service;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import org.junit.jupiter.api.Assertions;
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
public class CreateUserCommandTest {

    private BCryptPasswordEncoder encoder;

    @Autowired
    CreateUserCommandImpl createUserCommand;

    @BeforeEach
    void setup(){
        encoder = new BCryptPasswordEncoder();
    }

    @Test
    void CreateUserCommand_ExecuteTest(){
        String password = "P@ssw0rd";
        CreateUserDto createUserDto = new CreateUserDto(
            1L,
            "John",
            "johnny94",
            "john@gmail.com",
            "98765432",
            encoder.encode(password),
            new ArrayList<>()
        );

        AppUserDto result = createUserCommand.execute(createUserDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2L,result.getId());
        Assertions.assertEquals("John",result.getName());
        Assertions.assertEquals("johnny94",result.getUsername());
        Assertions.assertEquals("john@gmail.com",result.getEmail());
        Assertions.assertEquals("98765432",result.getContactNumber());
        Assertions.assertEquals(0, result.getRoleDtos().size());
    }
}
