package com.access.accountmanagement.account.service;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import com.access.accountmanagement.account.service.basecommands.AppUser.SaveAppUserCommand;
import com.access.accountmanagement.account.service.utility.UtilityMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreateUserCommandImpl implements CreateUserCommand{

    @Autowired
    private UtilityMapperService utilityMapperService;

    @Autowired
    private SaveAppUserCommand saveAppUserCommand;

    @Override
    public AppUserDto execute(CreateUserDto variable) {
        AppUser userCreated = saveAppUserCommand.execute(utilityMapperService.toEntityFromDto(variable));
        return utilityMapperService.toAppUserDtoFromAppUser(userCreated);
    }
}
