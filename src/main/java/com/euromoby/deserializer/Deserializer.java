package com.euromoby.deserializer;

public interface Deserializer<T> {
    T deserialize(String value);
}
