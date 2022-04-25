package com.access.accountmanagement.common.commands;

@FunctionalInterface
public interface FunctionalCommandWithInput<T> {
    void execute(T object);
}
