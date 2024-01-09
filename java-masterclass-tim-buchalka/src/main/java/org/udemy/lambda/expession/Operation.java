package org.udemy.lambda.expession;


@FunctionalInterface
public interface Operation<T> {
    T operate(T value1, T value2);
}
