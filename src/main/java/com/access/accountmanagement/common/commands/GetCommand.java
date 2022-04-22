package com.access.accountmanagement.common.commands;

@FunctionalInterface
public interface GetCommand<T,P> {
    T execute(P parameter);
}
