package com.euromoby.deserializer;

import com.euromoby.exception.JsonException;
import com.euromoby.serializer.*;
import com.euromoby.util.Objects;
import com.euromoby.util.Strings;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ObjectDeserializer {

    final private Map<Class, TypeDeserializer> classDeserializerMap = defaultClassDeserializerMap();

    private static Map<Class, TypeDeserializer> defaultClassDeserializerMap() {
        Map<Class, TypeDeserializer> map = new HashMap<>();
        map.put(Boolean.class, new BooleanDeserializer());
        map.put(Date.class, new DateDeserializer());
        map.put(Double.class, new DoubleDeserializer());
        map.put(Float.class, new FloatDeserializer());
        map.put(Integer.class, new IntegerDeserializer());
        map.put(String.class, new StringDeserializer());
        return map;
    }

    public <T> T deserialize(String s, Class<T> clazz) {
        String trimmed = s.trim();

        if (Objects.NULL.equals(trimmed)) return null;
        try {
            if (trimmed.charAt(0) == Strings.OBJECT_START) {
                return (T)deserializeObject(s, 0, clazz);
            }
            if (trimmed.charAt(0) == Strings.ARRAY_START && clazz.isArray()) {
                return (T)deserializeArray(s, 0, clazz.getComponentType());
            }
        } catch (Exception e) {
            throw new JsonException("Invalid Object value: " + s, e);
        }

        throw new JsonException("Invalid Object value: " + s);
    }

    public <T> T deserializeObject(String s, int offset, Class<T> clazz) throws Exception {
        T instance = clazz.newInstance();
        ParserState parserState = new ParserState();

        StringBuffer name = new StringBuffer();
        StringBuffer value = new StringBuffer();

        for (int i = offset; i < s.length(); i++) {
            char c = s.charAt(i);
            parserState.push(c, i);

            if (parserState.insideName()) {
                name.append(c);
                continue;
            } else if (parserState.insideValue()) {
                value.append(c);
                continue;
            } else if (parserState.valueEnded) {
                setFieldValue(instance, name.toString(), value.toString());
            }

        }
        return instance;
    }

    public <T> void setFieldValue(T instance, String name, String value) {
        String fieldName = Strings.dequote(name.trim());

        try {
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            Class clazz = field.getType();
            TypeDeserializer deserializer = classDeserializerMap.get(clazz);
            if (deserializer != null) {
                field.set(instance, deserializer.deserialize(value));
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // ignore
        }
    }

    public <T> T[] deserializeArray(String s, int offset, Class<T> clazz) {
        Object array = Array.newInstance(clazz, 0);
        return (T[])array;
    }

    public class ParserState {
        public boolean objectStarted = false;
        public boolean objectEnded = false;
        public boolean nameStarted = false;
        public boolean nameEnded = false;
        public boolean valueStarted = false;
        public boolean valueEnded = false;

        public boolean insideName() {
            return nameStarted && !nameEnded;
        }

        public boolean insideValue() {
            return valueStarted && !valueEnded;
        }

        public boolean readingData() {
            return insideName() || insideValue();
        }

        public void push(char c, int i) throws JsonException {
            if (Strings.whitespace(c)) return;

            try {
                switch (c) {
                    case Strings.OBJECT_START:
                        handleObjectStart();
                        break;
                    case Strings.OBJECT_END:
                        handleObjectEnd();
                        break;
                    case Strings.TYPE_SEPARATOR:
                        handleTypeSeparator();
                        break;
                    case Strings.FIELD_SEPARATOR:
                        handleFieldSeparator();
                        break;
                    default:
                        handleDefault();
                }
            } catch (Exception e) {
                throw new JsonException("Invalid character: " + c + " at " + i);
            }
        }

        private void handleObjectStart() {
            //if (readingData()) return;
            if (objectStarted) throw new JsonException();

            objectStarted = true;
        }

        private void handleObjectEnd() {
            //if (readingData()) return;
            if (!objectStarted || objectEnded) throw new JsonException();

            objectEnded = true;
            valueEnded = true;
        }

        private void handleTypeSeparator() {
            //if (readingData()) return;
            if (!nameStarted || nameEnded) throw new JsonException();

            nameEnded = true;
        }

        private void handleFieldSeparator() {
            //if (readingData()) return;
            if (!valueStarted || valueEnded) throw new JsonException();

            valueEnded = true;
        }

        private void handleDefault() {
            if (readingData()) return;

            if (!nameStarted) {
                nameStarted = true;
                return;
            }

            if (!valueStarted) {
                valueStarted = true;
                return;
            }

            throw new JsonException();
        }

    }

}
