package com.access.accountmanagement.common.genericCommands;

@FunctionalInterface
public interface GetCommand<T,P> {
    T execute(P parameter);
}
