package com.access.accountmanagement.account.service.Role;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.repository.RoleRepository;
import com.access.accountmanagement.genericCommands.DeleteCommand;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public record DeleteRoleCommand(RoleRepository roleRepository) implements DeleteCommand<Role> {
    @Override
    public void execute(Role object) {
        roleRepository.delete(object);
    }
}
