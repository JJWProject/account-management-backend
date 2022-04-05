package com.access.accountmanagement.genericCommands;

@FunctionalInterface
public interface GetCommand<T,R> {
    T execute(R parameter);
}
