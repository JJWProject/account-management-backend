package com.access.accountmanagement.common.commands;

@FunctionalInterface
public interface FunctionalCommandWithReturnType<T,R> {
    R execute(T variable);
}
