package com.access.accountmanagement.common.genericCommands;

@FunctionalInterface
public interface DeleteCommand<T> {
    void execute(T object);
}
