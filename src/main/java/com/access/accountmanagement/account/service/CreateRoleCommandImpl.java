package com.access.accountmanagement.account.service;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.dto.RoleDto;
import com.access.accountmanagement.account.mapper.RoleMapper;
import com.access.accountmanagement.account.service.basecommands.Role.SaveRoleCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRoleCommandImpl implements CreateRoleCommand{

    private final RoleMapper roleMapper;
    private final SaveRoleCommand saveRoleCommand;

    @Override
    public RoleDto execute(RoleDto variable) {
        Role role = roleMapper.toEntity(variable);
        return roleMapper.toDto(saveRoleCommand.execute(role));
    }
}
