package com.euromoby.serializer;

import com.euromoby.util.Objects;

public class IntegerSerializer implements TypeSerializer<Integer> {
    public String serialize(Integer i) {
        if (i == null) {
            return Objects.NULL;
        }
        return i.toString();
    }
}
