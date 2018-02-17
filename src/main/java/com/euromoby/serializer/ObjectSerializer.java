package com.euromoby.serializer;

import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ObjectSerializer {
    final private Map<Class, TypeSerializer> classSerializerMap = defaultClassSerializerMap();
    final private boolean pretty;
    final private boolean skipNulls;

    private static Map<Class, TypeSerializer> defaultClassSerializerMap() {
        Map<Class, TypeSerializer> map = new HashMap<>();
        map.put(Boolean.class, new BooleanSerializer());
        map.put(Date.class, new DateSerializer());
        map.put(Double.class, new DoubleSerializer());
        map.put(Float.class, new FloatSerializer());
        map.put(Integer.class, new IntegerSerializer());
        map.put(String.class, new StringSerializer());
        return map;
    }

    public ObjectSerializer() {
        this(false,false);
    }

    public ObjectSerializer(boolean pretty, boolean skipNulls) {
        this.pretty = pretty;
        this.skipNulls = skipNulls;
    }

    public String serialize(Object o) {
        return serialize(o, 0);
    }

    public String serialize(Object o, int tabs) {
        if (o == null) {
            return Objects.NULL;
        }

        if (o.getClass().isArray()) {
            return serializeArray((Object[])o, tabs);
        }

        return serializeObject(o, tabs);
    }

    private String serializeObject(Object o, int tabs) {
        String objectIndentation = Strings.tabs(tabs);
        String fieldIndentation = Strings.tabs(tabs + 1);

        Class clazz = o.getClass();
        TypeSerializer serializer = classSerializerMap.get(clazz);
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
                if (fieldName.indexOf(Strings.DOLLAR) != -1) continue;
                field.setAccessible(true);
                Object fieldValue = field.get(o);

                if (skipNulls && fieldValue == null) {
                    continue;
                }

                if (pretty) {
                    sb.append(Strings.CRLF);
                    sb.append(fieldIndentation);
                }
                sb.append(Strings.enquote(fieldName));
                sb.append(Strings.TYPE_SEPARATOR);
                if (pretty) sb.append(" ");
                sb.append(serialize(fieldValue, tabs + 1));
                sb.append(Strings.FIELD_SEPARATOR);
                comma = true;
            }
        } catch (IllegalAccessException iae) {
            throw new RuntimeException(iae);
        }
        if (comma) sb.deleteCharAt(sb.length()-Strings.FIELD_SEPARATOR_LENGTH);

        if (pretty) {
            sb.append(Strings.CRLF);
            sb.append(objectIndentation);
        }
        sb.append(Strings.OBJECT_END);
        return sb.toString();
    }

    private String serializeArray(Object[] array, int tabs) {
        String arrayIndentation = Strings.tabs(tabs);
        String valueIndentation = Strings.tabs(tabs + 1);

        StringBuffer sb = new StringBuffer();
        sb.append(Strings.ARRAY_START);

        boolean comma = false;
        for (Object o: array) {
            if (pretty) {
                sb.append(Strings.CRLF);
                sb.append(valueIndentation);
            }
            sb.append(serialize(o, tabs + 1));
            sb.append(Strings.FIELD_SEPARATOR);
            comma = true;
        }
        if (comma) sb.deleteCharAt(sb.length()-Strings.FIELD_SEPARATOR_LENGTH);

        if (pretty) {
            sb.append(Strings.CRLF);
            sb.append(arrayIndentation);
        }
        sb.append(Strings.ARRAY_END);
        return sb.toString();
    }

}
