package com.access.accountmanagement.account.service.AppUser;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.repository.AppUserRepository;
import com.access.accountmanagement.genericCommands.DeleteCommand;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public record DeleteAppUserCommand(AppUserRepository appUserRepository) implements DeleteCommand<AppUser> {
    @Override
    public void execute(AppUser object) {
        appUserRepository.delete(object);
    }
}
