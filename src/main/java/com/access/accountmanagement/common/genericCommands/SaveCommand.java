package com.access.accountmanagement.common.genericCommands;

@FunctionalInterface
public interface SaveCommand<T> {
    T execute(T variable);
}
