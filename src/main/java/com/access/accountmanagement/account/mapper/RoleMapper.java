package com.access.accountmanagement.account.mapper;

import com.access.accountmanagement.account.domain.Role;
import com.access.accountmanagement.account.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {

    Role toEntity(RoleDto roleDto);

    RoleDto toDto(Role role);

}
