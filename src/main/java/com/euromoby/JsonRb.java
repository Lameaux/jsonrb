package com.euromoby;

import java.util.Date;

public class JsonRb {

    public static void main(String args[]) {

        Object o = new Object() {
            String nullValue = null;
            String string = "Hello";
            Boolean boolTrue = true;
            boolean boolFalse = false;
            Integer i1 = 1;
            int i2 = 2;
            Date date = new Date();
            Float f = 1.234f;
            Double d = 2.345;
            Object nested1 = new Object() {
                String name = "Nested1";
            };
            Object nested2 = new Object() {
                String name = "Nested2";
            };

            String[] arrays = new String[] {"str1", "str2", "str3"};

        };

        JsonSerializer compactSerializer = new JsonSerializer(false, true);
        System.out.println(compactSerializer.serialize(o));

        JsonSerializer prettySerializer = new JsonSerializer(true, false);
        System.out.println(prettySerializer.serialize(o));
    }

}
