package com.access.accountmanagement.common.genericCommands;

@FunctionalInterface
public interface FunctionalCommandWithReturnType<T,R> {
    R execute(T variable);
}
