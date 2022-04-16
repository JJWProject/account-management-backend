package com.access.accountmanagement.account.mapper;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.dto.RoleDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface RoleMapper {

    Role toEntity(RoleDto roleDto);

    List<Role> toEntityList(List<RoleDto> roleDtoList);

    RoleDto toDto(Role role);

    List<RoleDto> toDtoList(List<Role> roleList);
}
