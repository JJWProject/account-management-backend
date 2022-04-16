package com.access.accountmanagement.account.service.basecommands.AppUser;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GetAppUserByUserNameCommandImpl implements GetAppUserByUserNameCommand {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser execute(String parameter) {
        return appUserRepository.findByUsername(parameter);
    }
}
