package com.access.accountmanagement.account.service.AppUser;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.repository.AppUserRepository;
import com.access.accountmanagement.genericCommands.DeleteCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteAppUserCommand implements DeleteCommand<AppUser> {

    private final AppUserRepository appUserRepository;

    @Override
    public void execute(AppUser object) {
        appUserRepository.delete(object);
    }
}
