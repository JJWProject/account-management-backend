package com.access.accountmanagement.authentication.service.jwt;

import com.access.accountmanagement.common.commands.FunctionalCommandWithTwoVariableAndReturnType;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface GenerateJwtCommand extends FunctionalCommandWithTwoVariableAndReturnType<User, HttpServletRequest, Map<String,String>> {
}
