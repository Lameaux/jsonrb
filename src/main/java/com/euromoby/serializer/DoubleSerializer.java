package com.euromoby.serializer;

import com.euromoby.util.Objects;

public class DoubleSerializer implements Serializer<Double> {
    public String serialize(Double d) {
        if (d == null) {
            return Objects.NULL;
        }
        return d.toString();
    }
}
