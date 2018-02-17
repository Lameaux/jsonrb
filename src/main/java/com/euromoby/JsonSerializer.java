package com.euromoby;

import com.euromoby.serializer.ObjectSerializer;

public class JsonSerializer {

    private final ObjectSerializer objectSerializer;

    public JsonSerializer() {
        this(false, false);
    }

    public JsonSerializer(boolean pretty, boolean skipNulls) {
        objectSerializer = new ObjectSerializer(pretty, skipNulls);
    }

    public String serialize(Object o) {
        return objectSerializer.serialize(o);
    }
}
