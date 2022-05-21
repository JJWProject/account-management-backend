package com.access.accountmanagement.account.service;

import com.access.accountmanagement.account.dto.RoleDto;
import com.access.accountmanagement.account.mapper.RoleMapper;
import com.access.accountmanagement.account.service.basecommands.Role.GetRoleByNameCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class GetRoleDtoByNameCommandImpl implements GetRoleDtoByNameCommand{

    private final GetRoleByNameCommand getRoleByNameCommand;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto execute(String parameter) {
        return roleMapper.toDto(getRoleByNameCommand.execute(parameter));
    }
}
