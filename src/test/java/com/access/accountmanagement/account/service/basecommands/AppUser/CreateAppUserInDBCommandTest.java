package com.access.accountmanagement.account.service.basecommands.AppUser;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.dto.user.AppUserDto;
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
public class CreateAppUserInDBCommandTest {

    private BCryptPasswordEncoder encoder;

    @Autowired
    CreateAppUserInDBCommandImpl createAppUserInDBCommand;

    @BeforeEach
    void setup(){
        encoder = new BCryptPasswordEncoder();
    }

    @Test
    void CreateAppUserInDBCommand_ExecuteTest(){
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

        AppUser result = createAppUserInDBCommand.execute(appUser);

        Assertions.assertNotNull(result);
        if(result.getId().equals(2L)){
            Assertions.assertEquals(2L,result.getId());
        }else {
            Assertions.assertEquals(1L,result.getId());
        }
        Assertions.assertEquals("John",result.getName());
        Assertions.assertEquals("johnny94",result.getUsername());
        Assertions.assertEquals("john@gmail.com",result.getEmail());
        Assertions.assertEquals("98765432",result.getContactNumber());
        Assertions.assertEquals(0, result.getRoles().size());
    }
}
