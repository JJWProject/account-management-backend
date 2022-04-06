package com.access.accountmanagement.account.service.Role;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.repository.RoleRepository;
import com.access.accountmanagement.genericCommands.GetCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public record GetRollByNameCommand(RoleRepository roleRepository) implements GetCommand<Role, String> {

    @Override
    public Role execute(String parameter) {
        return roleRepository.findByName(parameter);
    }
}
