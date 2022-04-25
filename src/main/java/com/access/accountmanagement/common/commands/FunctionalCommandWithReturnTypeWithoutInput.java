package com.access.accountmanagement.common.commands;

@FunctionalInterface
public interface FunctionalCommandWithReturnTypeWithoutInput<R>{
    R execute();
}
