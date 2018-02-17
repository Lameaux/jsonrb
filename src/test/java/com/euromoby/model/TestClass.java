package com.euromoby.model;

import java.util.Objects;

public class TestClass {
    String string = "Hello";
    Boolean boolTrue = true;
    boolean boolFalse = false;
    Integer i1 = 1;
    int i2 = 2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestClass testClass = (TestClass) o;
        return boolFalse == testClass.boolFalse &&
                i2 == testClass.i2 &&
                Objects.equals(string, testClass.string) &&
                Objects.equals(boolTrue, testClass.boolTrue) &&
                Objects.equals(i1, testClass.i1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, boolTrue, boolFalse, i1, i2);
    }
}
