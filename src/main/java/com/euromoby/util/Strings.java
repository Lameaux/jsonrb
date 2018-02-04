package com.euromoby.util;

public class Strings {

    public static String quotes(String s) {
        return "\"" + s + "\"";
    }

    public static String escape(String s) {
        StringBuffer sb = new StringBuffer(s.length() * 2);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            switch (c) {
                case '\b' : sb.append("\\b"); break;
                case '\f' : sb.append("\\f"); break;
                case '\n' : sb.append("\\n"); break;
                case '\r' : sb.append("\\r"); break;
                case '\t' : sb.append("\\t"); break;
                case '\"' : sb.append("\\\""); break;
                case '\\' : sb.append("\\\\"); break;
                default: sb.append(c);
            }
        }
        return sb.toString();
    }
}
