package com.access.accountmanagement.authentication.service;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.service.basecommands.AppUser.GetAppUserByUserNameCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthenticateUserCommandImpl implements UserDetailsService {

    private final GetAppUserByUserNameCommand getAppUserByUserNameCommand;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = getAppUserByUserNameCommand.execute(username);
        if (appUser == null) {
            log.error("User not found in database");
            throw new UsernameNotFoundException("User not found in database");
        } else {
            log.info("User found in database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        User user = new User(appUser.getUsername(), appUser.getPassword(), authorities);
        return user;
    }
}
