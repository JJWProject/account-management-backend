package com.access.accountmanagement.account.domain;

import com.access.accountmanagement.AccountmanagementApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AccountmanagementApplication.class)
public class RoleTest {
    @Test
    void Role_InitTest(){
        Role role = new Role();
        Assertions.assertNotNull(role);
    }

    @Test
    void Role_AllArgsConstructorTest(){
        Role role = new Role(1L, "Common");

        Assertions.assertNotNull(role);

        Assertions.assertEquals(1L, role.getId());
        Assertions.assertEquals("Common",role.getName());
    }

    @Test
    void Role_GetterSetterTest(){
        Role role = new Role();

        role.setId(1L);
        Assertions.assertEquals(1L,role.getId());

        role.setName("Common");
        Assertions.assertEquals("Common",role.getName());
    }

    @Test
    void Role_ToStringTest(){
        Role role = new Role(1L, "Common");

        Assertions.assertNotNull(role);
        Assertions.assertEquals("Role(id=1, name=Common)",role.toString());
    }
}
