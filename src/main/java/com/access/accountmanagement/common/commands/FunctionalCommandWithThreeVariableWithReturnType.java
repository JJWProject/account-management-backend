package com.access.accountmanagement.common.commands;

public interface FunctionalCommandWithThreeVariableWithReturnType<T1,T2,T3,R> {
    R execute(T1 variable1, T2 variable2, T3 variable3);
}
