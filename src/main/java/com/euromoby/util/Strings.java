package com.euromoby.util;

import java.util.Arrays;

public class Strings {

    public static final String ARRAY_START = "[";
    public static final String ARRAY_END = "]";
    public static final String OBJECT_START = "{";
    public static final String OBJECT_END = "}";
    public static final String TYPE_SEPARATOR = ":";
    public static final String FIELD_SEPARATOR = ",";

    public static final char DOLLAR = '$';
    public static final char QUOTE = '"';
    public static final String CRLF = "\r\n";

    public static String enquote(String s) {
        return "\"" + s + "\"";
    }

    public static String dequote(String s) {
        if (s.length() < 2) return s;
        if (s.charAt(0) == QUOTE && s.charAt(s.length()-1) == QUOTE) {
            return s.substring(1, s.length()-1);
        }
        return s;
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
                case '"' : sb.append("\\\""); break;
                case '\\' : sb.append("\\\\"); break;
                default: sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String unescape(String s) {
        StringBuffer sb = new StringBuffer(s.length() * 2);
        char[] chars = s.toCharArray();
        boolean escaped = false;
        for (char c : chars) {

            if (escaped) {
                switch (c) {
                    case 'b' : sb.append('\b'); break;
                    case 'f' : sb.append('\f'); break;
                    case 'n' : sb.append('\n'); break;
                    case 'r' : sb.append('\r'); break;
                    case 't' : sb.append('\t'); break;
                    case '"' : sb.append('"'); break;
                    case '\\' : sb.append('\\'); break;
                    default: sb.append('\\').append(c);
                }
                escaped = false;
            } else {
                if (c == '\\') {
                    escaped = true;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static String tabs(int len) {
        char[] chars = new char[len];
        Arrays.fill(chars, '\t');
        return new String(chars);
    }
}
