package com.access.accountmanagement.account.service.basecommands.Role;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DeleteRoleCommandImpl implements DeleteRoleCommand {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void execute(Role object) {
        roleRepository.delete(object);
    }
}
