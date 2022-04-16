package com.access.accountmanagement.account.service.utility;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.dto.RoleDto;
import com.access.accountmanagement.account.dto.user.AppUserDto;
import com.access.accountmanagement.account.dto.user.CreateUserDto;
import com.access.accountmanagement.account.mapper.AppUserMapper;
import com.access.accountmanagement.account.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilityMapperServiceImpl implements UtilityMapperService{

    @Autowired
    private AppUserMapper appUserMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public AppUser toEntityFromDto(CreateUserDto createUserDto) {
        AppUser appUser = appUserMapper.toEntityFromCreateUserDto(createUserDto);
        List<RoleDto> roleDtoList = createUserDto.getRoleDtos();
        List<Role> roleList = roleMapper.toEntityList(roleDtoList);
        appUser.setRoles(roleList);
        return appUser;
    }

    @Override
    public AppUser toEntityFromDto(AppUserDto appUserDto) {
        AppUser appUser = appUserMapper.toEntityFromAppUserDto(appUserDto);
        List<RoleDto> roleDtoList = appUserDto.getRoleDtos();
        List<Role> roleList = roleMapper.toEntityList(roleDtoList);
        appUser.setRoles(roleList);
        return appUser;
    }

    @Override
    public CreateUserDto toCreateUserDtoFromAppUser(AppUser appUser) {
        CreateUserDto createUserDto = appUserMapper.toDTOToCreateUserDto(appUser);
        List<Role> roleList = appUser.getRoles();
        List<RoleDto> roleDtoList = roleMapper.toDtoList(roleList);
        createUserDto.setRoleDtos(roleDtoList);
        return createUserDto;
    }

    @Override
    public AppUserDto toAppUserDtoFromAppUser(AppUser appUser) {
        AppUserDto appUserDto = appUserMapper.toDTOToAppUserDto(appUser);
        List<Role> roleList = appUser.getRoles();
        List<RoleDto> roleDtoList = roleMapper.toDtoList(roleList);
        appUserDto.setRoleDtos(roleDtoList);
        return appUserDto;
    }
}
