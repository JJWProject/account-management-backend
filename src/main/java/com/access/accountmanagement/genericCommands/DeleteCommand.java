package com.access.accountmanagement.genericCommands;

@FunctionalInterface
public interface DeleteCommand<T> {
    void execute(T object);
}
