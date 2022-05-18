package com.access.accountmanagement.account.dto.user;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.dto.RoleDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = AccountmanagementApplication.class)
public class AppUserDtoTest {
    @Test
    void AppUserDto_InitTest(){
        AppUserDto appUserDto = new AppUserDto();
        Assertions.assertNotNull(appUserDto);
    }

    @Test
    void AppUserDto_AllArgsConstructorTest(){
        List<RoleDto> roleDtoList = new ArrayList<>();
        AppUserDto appUserDto = new AppUserDto(
            1L,
            "John",
            "johnny",
            "john@gmail.com",
            "98765432",
            roleDtoList
        );
        Assertions.assertNotNull(appUserDto);
        Assertions.assertEquals(1L,appUserDto.getId());
        Assertions.assertEquals("John",appUserDto.getName());
        Assertions.assertEquals("johnny",appUserDto.getUsername());
        Assertions.assertEquals("john@gmail.com",appUserDto.getEmail());
        Assertions.assertEquals("98765432",appUserDto.getContactNumber());
        Assertions.assertEquals(0,appUserDto.getRoleDtos().size());
    }

    @Test
    void AppUserDto_GetterSetterTest(){
        List<RoleDto> roleDtoList = new ArrayList<>();
        AppUserDto appUserDto = new AppUserDto();
        Assertions.assertNotNull(appUserDto);

        appUserDto.setId(1L);
        Assertions.assertEquals(1L,appUserDto.getId());

        appUserDto.setName("John");
        Assertions.assertEquals("John",appUserDto.getName());

        appUserDto.setUsername("johnny");
        Assertions.assertEquals("johnny",appUserDto.getUsername());

        appUserDto.setEmail("john@gmail.com");
        Assertions.assertEquals("john@gmail.com",appUserDto.getEmail());

        appUserDto.setContactNumber("98765432");
        Assertions.assertEquals("98765432",appUserDto.getContactNumber());

        appUserDto.setRoleDtos(roleDtoList);
        Assertions.assertEquals(0,appUserDto.getRoleDtos().size());
    }

    @Test
    void AppUserDto_ToStringTest(){
        List<RoleDto> roleDtoList = new ArrayList<>();
        AppUserDto appUserDto = new AppUserDto(
                1L,
                "John",
                "johnny",
                "john@gmail.com",
                "98765432",
                roleDtoList
        );
        Assertions.assertNotNull(appUserDto);
        Assertions.assertEquals("AppUserDto(id=1, name=John, username=johnny, email=john@gmail.com, contactNumber=98765432, roleDtos=[])",appUserDto.toString());
    }
}
