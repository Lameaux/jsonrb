package com.euromoby;

import com.euromoby.serializer.ObjectSerializer;
import com.euromoby.serializer.Serializer;
import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

import java.util.*;

public class JsonSerializer {

    private final ObjectSerializer objectSerializer;

    public JsonSerializer() {
        this(false);
    }

    public JsonSerializer(boolean pretty) {
        objectSerializer = new ObjectSerializer(pretty);
    }

    public String serialize(Object o) {
        return objectSerializer.serialize(o);
    }
}
