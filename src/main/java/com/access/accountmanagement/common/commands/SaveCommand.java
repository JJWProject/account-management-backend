package com.access.accountmanagement.common.commands;

@FunctionalInterface
public interface SaveCommand<T> {
    T execute(T variable);
}
