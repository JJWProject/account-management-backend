package com.access.accountmanagement.genericCommands;

@FunctionalInterface
public interface SaveCommand<T> {
    T execute(T variable);
}
