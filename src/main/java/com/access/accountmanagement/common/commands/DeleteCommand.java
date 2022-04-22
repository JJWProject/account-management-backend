package com.access.accountmanagement.common.commands;

@FunctionalInterface
public interface DeleteCommand<T> {
    void execute(T object);
}
