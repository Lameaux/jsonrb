package com.euromoby.serializer;

import com.euromoby.util.Objects;

public class BooleanSerializer implements TypeSerializer<Boolean> {
    public String serialize(Boolean b) {
        if (b == null) {
            return Objects.NULL;
        }
        return b ? Objects.TRUE : Objects.FALSE;
    }
}
