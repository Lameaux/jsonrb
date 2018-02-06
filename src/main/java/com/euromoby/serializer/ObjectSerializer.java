package com.euromoby.serializer;

import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ObjectSerializer implements Serializer<Object> {
    final private Map<Class, Serializer> classSerializerMap;
    final private boolean pretty;

    public ObjectSerializer() {
        this(false);
    }

    public ObjectSerializer(boolean pretty) {
        this(defaultClassSerializerMap(), pretty);
    }

    private static Map<Class, Serializer> defaultClassSerializerMap() {
        Map<Class, Serializer> map = new HashMap<>();
        map.put(Boolean.class, new BooleanSerializer());
        map.put(Date.class, new DateSerializer());
        map.put(Double.class, new DoubleSerializer());
        map.put(Float.class, new FloatSerializer());
        map.put(Integer.class, new IntegerSerializer());
        map.put(String.class, new StringSerializer());
        return map;
    }

    public ObjectSerializer(Map<Class, Serializer> classSerializerMap, boolean pretty) {
        this.classSerializerMap = classSerializerMap;
        this.pretty = pretty;
    }

    public String serialize(Object o) {
        return serialize(o, 0);
    }

    public String serialize(Object o, int tabs) {
        String objectIdentation = Strings.tabs(tabs);
        String fieldIdentation = Strings.tabs(tabs + 1);

        if (o == null) {
            return Objects.NULL;
        }

        Class clazz = o.getClass();
        Serializer serializer = classSerializerMap.get(clazz);
        if (serializer != null) {
            return serializer.serialize(o);
        }

        StringBuffer sb = new StringBuffer();

        sb.append(Strings.OBJECT_START);

        boolean comma = false;
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();
                if (fieldName.contains(Strings.DOLLAR)) continue;
                field.setAccessible(true);
                Object fieldValue = field.get(o);

                if (pretty) {
                    sb.append(Strings.CRLF);
                    sb.append(fieldIdentation);
                }
                sb.append(Strings.quotes(fieldName));
                sb.append(Strings.TYPE_SEPARATOR);
                if (pretty) sb.append(" ");
                sb.append(serialize(fieldValue, tabs + 1));
                sb.append(Strings.FIELD_SEPARATOR);
                comma = true;
            }
        } catch (IllegalAccessException iae) {
            throw new RuntimeException(iae);
        }
        if (comma) sb.deleteCharAt(sb.length()-Strings.FIELD_SEPARATOR.length());

        if (pretty) {
            sb.append(Strings.CRLF);
            sb.append(objectIdentation);
        }
        sb.append(Strings.OBJECT_END);
        return sb.toString();
    }


}
