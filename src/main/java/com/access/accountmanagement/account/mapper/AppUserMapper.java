package com.access.accountmanagement.account.mapper;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AppUserMapper {

    @Mapping(target = "roles", source = "roleDtos")
    AppUser toEntityFromAppUserDto(AppUserDto appUserDto);

    @Mapping(target = "roleDtos", source = "roles")
    AppUserDto toDTOToAppUserDto(AppUser appUser);

    @Mapping(target = "roles", source = "roleDtos")
    AppUser toEntityFromCreateUserDto(CreateUserDto createUserDto);

    @Mapping(target = "roleDtos", source = "roles")
    CreateUserDto toDTOToCreateUserDto(AppUser appUser);
}
