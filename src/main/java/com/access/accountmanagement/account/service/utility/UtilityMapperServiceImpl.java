package com.access.accountmanagement.account.service.utility;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.dto.RoleDto;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import com.access.accountmanagement.account.mapper.AppUserMapper;
import com.access.accountmanagement.account.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UtilityMapperServiceImpl implements UtilityMapperService{

    private final AppUserMapper appUserMapper;
    private final RoleMapper roleMapper;

    @Override
    public AppUser toEntityFromDto(CreateUserDto createUserDto) {
        AppUser appUser = appUserMapper.toEntityFromCreateUserDto(createUserDto);
        List<RoleDto> roleDtoList = createUserDto.getRoleDtos();
        List<Role> roleList = roleDtoList.stream().map(roleDto->roleMapper.toEntity(roleDto))
                .collect(Collectors.toList());
        appUser.setRoles(roleList);
        return appUser;
    }

    @Override
    public AppUser toEntityFromDto(AppUserDto appUserDto) {
        AppUser appUser = appUserMapper.toEntityFromAppUserDto(appUserDto);
        List<RoleDto> roleDtoList = appUserDto.getRoleDtos();
        List<Role> roleList = roleDtoList.stream().map(roleDto->roleMapper.toEntity(roleDto))
                .collect(Collectors.toList());
        appUser.setRoles(roleList);
        return appUser;
    }

    @Override
    public CreateUserDto toCreateUserDtoFromAppUser(AppUser appUser) {
        CreateUserDto createUserDto = appUserMapper.toDTOToCreateUserDto(appUser);
        List<Role> roleList = appUser.getRoles();
        List<RoleDto> roleDtoList = roleList.stream().map(role->roleMapper.toDto(role))
                .collect(Collectors.toList());
        createUserDto.setRoleDtos(roleDtoList);
        return createUserDto;
    }

    @Override
    public AppUserDto toAppUserDtoFromAppUser(AppUser appUser) {
        AppUserDto appUserDto = appUserMapper.toDTOToAppUserDto(appUser);
        List<Role> roleList = appUser.getRoles();
        List<RoleDto> roleDtoList = roleList.stream().map(role->roleMapper.toDto(role))
                .collect(Collectors.toList());
        appUserDto.setRoleDtos(roleDtoList);
        return appUserDto;
    }
}
