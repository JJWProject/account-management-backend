package com.access.accountmanagement.account.service;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import com.access.accountmanagement.account.service.basecommands.AppUser.SaveAppUserCommand;
import com.access.accountmanagement.account.service.utility.UtilityMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateUserCommandImpl implements CreateUserCommand{

    private final UtilityMapperService utilityMapperService;
    private final SaveAppUserCommand saveAppUserCommand;

    @Override
    public AppUserDto execute(CreateUserDto variable) {
        AppUser userCreated = saveAppUserCommand.execute(utilityMapperService.toEntityFromDto(variable));
        return utilityMapperService.toAppUserDtoFromAppUser(userCreated);
    }
}
