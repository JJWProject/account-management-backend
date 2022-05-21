package com.access.accountmanagement.account.service;

import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.common.commands.FunctionalCommandWithReturnTypeWithoutInput;

import java.util.List;

public interface FindAllAppUserCommand extends FunctionalCommandWithReturnTypeWithoutInput<List<AppUserDto>> {
}
