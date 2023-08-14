package com.access.accountmanagement.common.enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.access.accountmanagement.common.enums.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    COMMON_USER(Sets.newHashSet()),
    ADMIN_USER(Sets.newHashSet(
        ROLE_READ,
        ROLE_WRITE,
        USER_READ,
        USER_WRITE
    ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
