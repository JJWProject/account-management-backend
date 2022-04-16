package com.access.accountmanagement.account.service.utility;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;

public interface UtilityMapperService {
    AppUser toEntityFromDto(CreateUserDto createUserDto);
    AppUser toEntityFromDto(AppUserDto appUserDto);
    CreateUserDto toCreateUserDtoFromAppUser(AppUser createUserDto);
    AppUserDto toAppUserDtoFromAppUser(AppUser appUserDto);
}
