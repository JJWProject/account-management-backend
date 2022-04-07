package com.access.accountmanagement.account.service.AppUser;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.repository.AppUserRepository;
import com.access.accountmanagement.genericCommands.SaveCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public record SaveAppUserCommand(AppUserRepository appUserRepository) implements SaveCommand<AppUser> {

    @Override
    public AppUser execute(AppUser variable) {
        return appUserRepository.save(variable);
    }
}
