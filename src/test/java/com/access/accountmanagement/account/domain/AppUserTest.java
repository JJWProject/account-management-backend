package com.access.accountmanagement.account.domain;

import com.access.accountmanagement.AccountmanagementApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest(classes = AccountmanagementApplication.class)
public class AppUserTest {
    @Test
    void AppUser_InitWithNoArgsConstructorTest(){
        AppUser appUser = new AppUser();
        Assertions.assertNotNull(appUser);
    }

    @Test
    void AppUser_AllArgsConstructorTest(){
        AppUser appUser = new AppUser(
                1L,
                "john",
                "John",
                "john@gmail.com",
                "98765432",
                "password",
                new ArrayList<>()
        );
        Assertions.assertNotNull(appUser);
    }

    @Test
    void AppUser_GetterSetterTest(){
        AppUser appUser = new AppUser();

        appUser.setId(1L);
        Assertions.assertEquals(1L,appUser.getId());

        appUser.setName("john");
        Assertions.assertEquals("john",appUser.getName());

        appUser.setUsername("John");
        Assertions.assertEquals("John",appUser.getUsername());

        appUser.setEmail("john@gmail.com");
        Assertions.assertEquals("john@gmail.com",appUser.getEmail());

        appUser.setPassword("password");
        Assertions.assertEquals("password",appUser.getPassword());

        appUser.setContactNumber("98765432");
        Assertions.assertEquals("98765432",appUser.getContactNumber());

        appUser.setRoles(new ArrayList<>());
        Assertions.assertEquals(0,appUser.getRoles().size());
    }

    @Test
    void AppUser_ToStringTest(){
        AppUser appUser = new AppUser(
                1L,
                "john",
                "John",
                "john@gmail.com",
                "98765432",
                "password",
                new ArrayList<>()
        );
        Assertions.assertEquals(
            "AppUser(id=1, name=john, username=John, email=john@gmail.com, contactNumber=98765432, password=password, roles=[])",
            appUser.toString()
        );
    }
}
