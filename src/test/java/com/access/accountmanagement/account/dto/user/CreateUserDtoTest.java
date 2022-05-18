package com.access.accountmanagement.account.dto.user;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.dto.RoleDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = AccountmanagementApplication.class)
public class CreateUserDtoTest {
    @Test
    void CreateUserDto_InitTest(){
        CreateUserDto createUserDto = new CreateUserDto();
        Assertions.assertNotNull(createUserDto);
    }

    @Test
    void CreateUserDto_AllArgsConstructorTest(){
        List<RoleDto> roleDtoList = new ArrayList<>();
        CreateUserDto createUserDto = new CreateUserDto(
                1L,
                "John",
                "johnny",
                "john@gmail.com",
                "98765432",
                "P@ssw0rd",
                roleDtoList
        );
        Assertions.assertNotNull(createUserDto);
        Assertions.assertEquals(1L,createUserDto.getId());
        Assertions.assertEquals("John",createUserDto.getName());
        Assertions.assertEquals("johnny",createUserDto.getUsername());
        Assertions.assertEquals("john@gmail.com",createUserDto.getEmail());
        Assertions.assertEquals("98765432",createUserDto.getContactNumber());
        Assertions.assertEquals("P@ssw0rd",createUserDto.getPassword());
        Assertions.assertEquals(0,createUserDto.getRoleDtos().size());
    }

    @Test
    void CreateUserDto_GetterSetterTest(){
        List<RoleDto> roleDtoList = new ArrayList<>();
        CreateUserDto createUserDto = new CreateUserDto();
        Assertions.assertNotNull(createUserDto);

        createUserDto.setId(1L);
        Assertions.assertEquals(1L,createUserDto.getId());

        createUserDto.setName("John");
        Assertions.assertEquals("John",createUserDto.getName());

        createUserDto.setUsername("johnny");
        Assertions.assertEquals("johnny",createUserDto.getUsername());

        createUserDto.setEmail("john@gmail.com");
        Assertions.assertEquals("john@gmail.com",createUserDto.getEmail());

        createUserDto.setContactNumber("98765432");
        Assertions.assertEquals("98765432",createUserDto.getContactNumber());

        createUserDto.setPassword("P@ssw0rd");
        Assertions.assertEquals("P@ssw0rd",createUserDto.getPassword());

        createUserDto.setRoleDtos(roleDtoList);
        Assertions.assertEquals(0,createUserDto.getRoleDtos().size());
    }

    @Test
    void CreateUserDto_ToStringTest(){
        List<RoleDto> roleDtoList = new ArrayList<>();
        CreateUserDto createUserDto = new CreateUserDto(
                1L,
                "John",
                "johnny",
                "john@gmail.com",
                "98765432",
                "P@ssw0rd",
                roleDtoList
        );

        Assertions.assertNotNull(createUserDto);
        Assertions.assertEquals("CreateUserDto(id=1, name=John, username=johnny, email=john@gmail.com, contactNumber=98765432, password=P@ssw0rd, roleDtos=[])",createUserDto.toString());
    }
}
