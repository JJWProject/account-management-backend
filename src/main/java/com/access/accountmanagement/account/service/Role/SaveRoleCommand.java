package com.access.accountmanagement.account.service.Role;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.repository.RoleRepository;
import com.access.accountmanagement.genericCommands.SaveCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SaveRoleCommand implements SaveCommand<Role> {

    private final RoleRepository roleRepository;

    @Override
    public Role execute(Role variable) {
        return roleRepository.save(variable);
    }
}
