package com.access.accountmanagement.account.service.basecommands.Role;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SaveRoleCommandImpl implements SaveRoleCommand {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role execute(Role variable) {
        return roleRepository.save(variable);
    }
}
