package com.access.accountmanagement.account.service;

import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import com.access.accountmanagement.genericCommands.FunctionalCommandWithReturnType;

public interface CreateUserCommand extends FunctionalCommandWithReturnType<CreateUserDto,AppUserDto> {
}
