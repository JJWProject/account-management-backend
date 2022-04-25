package com.access.accountmanagement.account.service.basecommands.AppUser;

import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.repository.AppUserRepository;
import com.access.accountmanagement.account.service.utility.UtilityMapperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class FindAllAppUserCommandImpl implements FindAllAppUserCommand{

    private final AppUserRepository appUserRepository;
    private final UtilityMapperService utilityMapperService;

    @Override
    public List<AppUserDto> execute() {
        return appUserRepository.findAll().stream()
                .map(appUser -> utilityMapperService.toAppUserDtoFromAppUser(appUser))
                .collect(Collectors.toList());
    }
}
