package com.access.accountmanagement.account.service.AppUser;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.repository.AppUserRepository;
import com.access.accountmanagement.genericCommands.GetCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public record GetAppUserByUserNameCommand(AppUserRepository appUserRepository) implements GetCommand<AppUser, String> {

    @Override
    public AppUser execute(String parameter) {
        return appUserRepository.findByUserName(parameter);
    }
}
