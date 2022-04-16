package com.access.accountmanagement.genericCommands;

@FunctionalInterface
public interface FunctionalCommandWithReturnType<T,R> {
    R execute(T variable);
}
