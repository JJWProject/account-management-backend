package com.access.accountmanagement.account.service.basecommands.AppUser;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteAppUserCommandImpl implements DeleteAppUserCommand {

    private final AppUserRepository appUserRepository;

    @Override
    public void execute(AppUser object) {
        appUserRepository.delete(object);
    }
}
