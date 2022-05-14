package com.access.accountmanagement.authentication.service.jwt;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.common.commands.FunctionalCommandWithThreeVariableWithReturnType;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface RefreshJwtCommand extends FunctionalCommandWithThreeVariableWithReturnType<AppUser, HttpServletRequest,String, Map<String,String>> {
}
