package com.access.accountmanagement.account.service.Role;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.repository.RoleRepository;
import com.access.accountmanagement.genericCommands.DeleteCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteRoleCommand implements DeleteCommand<Role> {

    private final RoleRepository roleRepository;

    @Override
    public void execute(Role object) {
        roleRepository.delete(object);
    }
}
