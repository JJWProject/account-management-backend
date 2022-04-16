package com.access.accountmanagement.account.mapper;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface AppUserMapper {

    AppUser toEntityFromAppUserDto(AppUserDto appUserDto);

    AppUserDto toDTOToAppUserDto(AppUser appUser);

    AppUser toEntityFromCreateUserDto(CreateUserDto createUserDto);

    CreateUserDto toDTOToCreateUserDto(AppUser appUser);
}
