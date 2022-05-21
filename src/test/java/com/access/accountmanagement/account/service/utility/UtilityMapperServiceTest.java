package com.access.accountmanagement.account.service.utility;

import com.access.accountmanagement.AccountmanagementApplication;
import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.dto.RoleDto;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootTest(classes = AccountmanagementApplication.class)
public class UtilityMapperServiceTest {

    private final String password = "P@ssw0rd";
    private Role role;
    private RoleDto roleDto;
    private CreateUserDto createUserDto;
    private AppUserDto appUserDto;
    private AppUser appUser;

    private BCryptPasswordEncoder encoder;

    @Autowired
    UtilityMapperServiceImpl utilityMapperService;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        encoder = new BCryptPasswordEncoder();
        role = new Role(
                1L,
                "Common"
        );
        roleDto = new RoleDto(
                1L,
                "Common"
        );
        appUserDto = new AppUserDto(
            1L,
            "John",
            "johnny94",
            "john@gmail.com",
            "98765432",
            Arrays.asList(roleDto)
        );
        createUserDto = new CreateUserDto(
                1L,
                "John",
                "johnny94",
                "john@gmail.com",
                "98765432",
                encoder.encode(password),
                Arrays.asList(roleDto)
        );
        appUser = new AppUser(
                1L,
                "John",
                "johnny94",
                "john@gmail.com",
                "98765432",
                encoder.encode(password),
                Arrays.asList(role)
        );
    }

    @Test
    void UtilityMapperService_InitTest(){
        Assertions.assertNotNull(utilityMapperService);
    }

    @Test
    void UtilityMapperService_toEntityFromDtoCreateUserDtoTest(){
        AppUser result = utilityMapperService.toEntityFromDto(createUserDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L,result.getId());
        Assertions.assertEquals("John",result.getName());
        Assertions.assertEquals("johnny94",result.getUsername());
        Assertions.assertEquals("john@gmail.com",result.getEmail());
        Assertions.assertEquals("98765432",result.getContactNumber());
        Assertions.assertEquals(1, result.getRoles().size());

        Role role = result.getRoles().get(0);

        Assertions.assertEquals(1L, role.getId());
        Assertions.assertEquals("Common",role.getName());
    }

    @Test
    void UtilityMapperService_toEntityFromDtoAppUserDtoTest(){
        AppUser result = utilityMapperService.toEntityFromDto(appUserDto);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L,result.getId());
        Assertions.assertEquals("John",result.getName());
        Assertions.assertEquals("johnny94",result.getUsername());
        Assertions.assertEquals("john@gmail.com",result.getEmail());
        Assertions.assertEquals("98765432",result.getContactNumber());
        Assertions.assertEquals(1, result.getRoles().size());

        Role role = result.getRoles().get(0);

        Assertions.assertEquals(1L, role.getId());
        Assertions.assertEquals("Common",role.getName());
    }

    @Test
    void UtilityMapperService_toCreateUserDtoFromAppUserTest(){
        CreateUserDto result = utilityMapperService.toCreateUserDtoFromAppUser(appUser);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L,result.getId());
        Assertions.assertEquals("John",result.getName());
        Assertions.assertEquals("johnny94",result.getUsername());
        Assertions.assertEquals("john@gmail.com",result.getEmail());
        Assertions.assertEquals("98765432",result.getContactNumber());
//        Assertions.assertEquals(encoder.encode(password),result.getPassword());
        Assertions.assertEquals(1, result.getRoleDtos().size());

        RoleDto roleDto = result.getRoleDtos().get(0);
        Assertions.assertNotNull(roleDto);

        Assertions.assertEquals(1L, roleDto.getId());
        Assertions.assertEquals("Common",roleDto.getName());
    }

    @Test
    void UtilityMapperService_toAppUserDtoFromAppUserTest(){
        AppUserDto result = utilityMapperService.toAppUserDtoFromAppUser(appUser);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1L,result.getId());
        Assertions.assertEquals("John",result.getName());
        Assertions.assertEquals("johnny94",result.getUsername());
        Assertions.assertEquals("john@gmail.com",result.getEmail());
        Assertions.assertEquals("98765432",result.getContactNumber());
        Assertions.assertEquals(1, result.getRoleDtos().size());

        RoleDto roleDto = result.getRoleDtos().get(0);
        Assertions.assertNotNull(roleDto);

        Assertions.assertEquals(1L, roleDto.getId());
        Assertions.assertEquals("Common",roleDto.getName());
    }
}
