package com.euromoby;

import com.euromoby.serializer.ObjectSerializer;
import com.euromoby.serializer.Serializer;
import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

import java.util.*;

public class JsonSerializer {

    private final ObjectSerializer objectSerializer;

    public JsonSerializer() {
        objectSerializer = new ObjectSerializer();
    }

    public JsonSerializer(Map<Class, Serializer> classSerializerMap) {
        objectSerializer = new ObjectSerializer(classSerializerMap);
    }

    public String serialize(Object o) {
        return objectSerializer.serialize(o);
    }
}
