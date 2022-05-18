package com.access.accountmanagement.account.dto;

import com.access.accountmanagement.AccountmanagementApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AccountmanagementApplication.class)
public class RoleDtoTest {
    @Test
    void RoleDto_InitTest(){
        RoleDto roleDto = new RoleDto();
        Assertions.assertNotNull(roleDto);
    }

    @Test
    void RoleDto_AllArgsConstructorTest(){
        RoleDto roleDto = new RoleDto(
                1L,
                "common"
        );

        Assertions.assertNotNull(roleDto);
        Assertions.assertEquals(1L,roleDto.getId());
        Assertions.assertEquals("common",roleDto.getName());
    }

    @Test
    void RoleDto_GetterSetterTest(){
        RoleDto roleDto = new RoleDto();
        Assertions.assertNotNull(roleDto);

        roleDto.setId(1L);
        Assertions.assertEquals(1L,roleDto.getId());

        roleDto.setName("common");
        Assertions.assertEquals("common",roleDto.getName());
    }

    @Test
    void RoleDto_ToStringTest(){
        RoleDto roleDto = new RoleDto(
                1L,
                "common"
        );

        Assertions.assertNotNull(roleDto);
        Assertions.assertEquals("RoleDto(id=1, name=common)",roleDto.toString());
    }
}
