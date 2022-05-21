package com.access.accountmanagement.account.service;

import com.access.accountmanagement.account.dto.RoleDto;
import com.access.accountmanagement.common.commands.GetCommand;

public interface GetRoleDtoByNameCommand extends GetCommand<RoleDto, String> {
}
