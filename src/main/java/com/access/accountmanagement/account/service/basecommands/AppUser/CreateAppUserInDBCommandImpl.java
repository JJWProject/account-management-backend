package com.access.accountmanagement.account.service.basecommands.AppUser;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateAppUserInDBCommandImpl implements CreateAppUserInDBCommand {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUser execute(AppUser variable) {
        return appUserRepository.save(variable);
    }
}
