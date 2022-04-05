package com.access.accountmanagement.service;

import com.access.accountmanagement.domain.AppUser;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    AppUser getUser(String userName);
}
