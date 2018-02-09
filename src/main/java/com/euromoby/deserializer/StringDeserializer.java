package com.euromoby.deserializer;

import com.euromoby.serializer.Serializer;
import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

public class StringDeserializer implements Deserializer<String> {

    @Override
    public String deserialize(String s) {
        if (Objects.NULL.equals(s)) {
            return null;
        }
        return Strings.unescape(Strings.dequote(s));
    }
}
