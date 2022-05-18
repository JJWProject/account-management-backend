package com.access.accountmanagement.account.dto.user;

import com.access.accountmanagement.AccountmanagementApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AccountmanagementApplication.class)
public class ChangePwDtoTest {
    @Test
    void ChangePwDto_InitTest(){
        ChangePwDto changePwDto = new ChangePwDto();
        Assertions.assertNotNull(changePwDto);
    }

    @Test
    void ChangePwDto_AllArgsConstructorTest(){
        ChangePwDto changePwDto = new ChangePwDto(
                "John",
                "P@ssw0rd",
                "Passw0rd"
        );
        Assertions.assertNotNull(changePwDto);

        Assertions.assertEquals("John",changePwDto.getUserName());
        Assertions.assertEquals("P@ssw0rd",changePwDto.getOldPassword());
        Assertions.assertEquals("Passw0rd",changePwDto.getNewPassword());
    }

    @Test
    void ChangePwDto_GetterSetterTest(){
        ChangePwDto changePwDto = new ChangePwDto();
        Assertions.assertNotNull(changePwDto);

        changePwDto.setUserName("John");
        Assertions.assertEquals("John",changePwDto.getUserName());

        changePwDto.setOldPassword("P@ssw0rd");
        Assertions.assertEquals("P@ssw0rd",changePwDto.getOldPassword());

        changePwDto.setNewPassword("Passw0rd");
        Assertions.assertEquals("Passw0rd",changePwDto.getNewPassword());
    }

    @Test
    void ChangePwDto_ToStringTest(){
        ChangePwDto changePwDto = new ChangePwDto(
                "John",
                "P@ssw0rd",
                "Passw0rd"
        );
        Assertions.assertNotNull(changePwDto);

        Assertions.assertEquals("ChangePwDto(userName=John, oldPassword=P@ssw0rd, newPassword=Passw0rd)",changePwDto.toString());
    }
}
