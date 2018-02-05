package com.euromoby.serializer;

public interface Serializer<T> {
    String serialize(T value);
}
