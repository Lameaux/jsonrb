package com.euromoby.deserializer;

import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

public class StringDeserializer implements TypeDeserializer<String> {

    @Override
    public String deserialize(String s) {
        if (Objects.NULL.equals(s)) {
            return null;
        }
        return Strings.unescape(Strings.dequote(s));
    }
}
