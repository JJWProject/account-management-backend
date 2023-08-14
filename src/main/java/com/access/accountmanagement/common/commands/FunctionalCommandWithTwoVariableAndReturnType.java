package com.access.accountmanagement.common.commands;

public interface FunctionalCommandWithTwoVariableAndReturnType<T1,T2,R> {
    R execute(T1 variable1, T2 variable2);
}
