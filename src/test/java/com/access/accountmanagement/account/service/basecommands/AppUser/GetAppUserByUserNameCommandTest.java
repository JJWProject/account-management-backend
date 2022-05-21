package com.access.accountmanagement.account.service.basecommands.AppUser;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.domain.AppUser;
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
public class GetAppUserByUserNameCommandTest {

    private BCryptPasswordEncoder encoder;

    @Autowired
    CreateAppUserInDBCommandImpl createAppUserInDBCommand;

    @Autowired
    GetAppUserByUserNameCommandImpl getAppUserByUserNameCommand;

    @BeforeEach
    void setup(){
        encoder = new BCryptPasswordEncoder();
    }

    @Test
    void GetAppUserByUserNameCommand_ExecuteTest(){
        String password = "P@ssw0rd";
        AppUser result = getAppUserByUserNameCommand.execute("johnny94");
        if(result == null){
            AppUser appUser = new AppUser(
                1L,
                "John",
                "johnny94",
                "john@gmail.com",
                "98765432",
                encoder.encode(password),
                new ArrayList<>()
            );
            createAppUserInDBCommand.execute(appUser);

            result = getAppUserByUserNameCommand.execute("johnny94");
        }

        Assertions.assertNotNull(result);
        if(result.getId().equals(6L)){
            Assertions.assertEquals(6L,result.getId());
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
