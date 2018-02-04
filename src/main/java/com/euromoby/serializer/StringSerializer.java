package com.euromoby.serializer;

import com.euromoby.util.Strings;

public class StringSerializer {

    public String serialize(String s) {
        return Strings.quotes(Strings.escape(s));
    }
}
