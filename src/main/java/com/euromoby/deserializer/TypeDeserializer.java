package com.euromoby.deserializer;

public interface TypeDeserializer<T> {
    T deserialize(String value);
}
