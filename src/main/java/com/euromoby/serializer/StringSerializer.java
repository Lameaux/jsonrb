package com.euromoby.serializer;

import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

public class StringSerializer implements TypeSerializer<String> {

    public String serialize(String s) {
        if (s == null) {
            return Objects.NULL;
        }
        return Strings.enquote(Strings.escape(s));
    }
}
