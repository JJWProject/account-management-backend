package com.access.accountmanagement.authentication.service.jwt;

import com.access.accountmanagement.common.commands.FunctionalCommandWithReturnType;
import com.auth0.jwt.interfaces.DecodedJWT;

public interface VerifyJwtCommand extends FunctionalCommandWithReturnType<String, DecodedJWT> {
}
