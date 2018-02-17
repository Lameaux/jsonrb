package com.euromoby.model;

import java.util.Objects;

public class SimpleClass {
    String message = null;

    public SimpleClass() {

    }

    public SimpleClass(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleClass that = (SimpleClass) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
