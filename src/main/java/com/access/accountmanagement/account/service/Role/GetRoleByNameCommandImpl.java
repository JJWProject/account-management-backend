package com.access.accountmanagement.account.service.Role;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetRoleByNameCommandImpl implements GetRoleByNameCommand {

    private final RoleRepository roleRepository;

    @Override
    public Role execute(String parameter) {
        return roleRepository.findByName(parameter);
    }
}
