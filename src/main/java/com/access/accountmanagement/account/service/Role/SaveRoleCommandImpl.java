package com.access.accountmanagement.account.service.Role;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SaveRoleCommandImpl implements SaveRoleCommand {

    private final RoleRepository roleRepository;

    @Override
    public Role execute(Role variable) {
        return roleRepository.save(variable);
    }
}
