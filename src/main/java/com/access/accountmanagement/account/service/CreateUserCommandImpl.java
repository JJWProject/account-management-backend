package com.access.accountmanagement.account.service;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import com.access.accountmanagement.account.mapper.AppUserMapper;
import com.access.accountmanagement.account.service.basecommands.AppUser.SaveAppUserCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateUserCommandImpl implements CreateUserCommand{

    private final AppUserMapper appUserMapper;

    private final SaveAppUserCommand saveAppUserCommand;

    @Override
    public AppUserDto execute(CreateUserDto variable) {
        AppUser userCreated = saveAppUserCommand.execute(appUserMapper.toEntityFromCreateUserDto(variable));
        return appUserMapper.toDTOToAppUserDto(userCreated);
    }
}
