package com.access.accountmanagement.account.service.basecommands.AppUser;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.genericCommands.GetCommand;

public interface GetAppUserByUserNameCommand extends GetCommand<AppUser, String> {
}
