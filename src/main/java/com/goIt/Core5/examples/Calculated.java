package com.goIt.Core5.examples;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) // анотація для полів
public @interface Calculated { // робимо свою анотацію
    String value(); // в анотації обовязково треба буде додати value
}
