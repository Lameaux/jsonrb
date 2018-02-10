package com.euromoby.serializer;

import com.euromoby.util.Objects;

public class FloatSerializer implements TypeSerializer<Float> {
    public String serialize(Float f) {
        if (f == null) {
            return Objects.NULL;
        }
        return f.toString();
    }
}
