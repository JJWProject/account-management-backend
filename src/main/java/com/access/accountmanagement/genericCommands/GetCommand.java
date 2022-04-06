package com.access.accountmanagement.genericCommands;

@FunctionalInterface
public interface GetCommand<T,P> {
    T execute(P parameter);
}
