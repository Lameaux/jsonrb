package com.euromoby.serializer;

public interface TypeSerializer<T> {
    String serialize(T value);
}
