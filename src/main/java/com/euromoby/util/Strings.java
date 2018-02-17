package com.euromoby.util;

import java.util.Arrays;

public class Strings {

    public static final char ARRAY_START = '[';
    public static final char ARRAY_END = ']';
    public static final char OBJECT_START = '{';
    public static final char OBJECT_END = '}';
    public static final char TYPE_SEPARATOR = ':';
    public static final char FIELD_SEPARATOR = ',';
    public static final int FIELD_SEPARATOR_LENGTH = 1;

    public static final char BACKSPACE = '\b';
    public static final char LINEFEED = '\f';
    public static final char NEWLINE = '\n';
    public static final char RETURN = '\r';
    public static final char TAB = '\t';
    public static final char QUOTE = '"';
    public static final char BACKSLASH = '\\';
    public static final char DOLLAR = '$';
    public static final char SPACE = ' ';

    public static final String CRLF = "\r\n";

    public static String enquote(String s) {
        return QUOTE + s + QUOTE;
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
                case BACKSPACE : sb.append(BACKSLASH).append('b'); break;
                case LINEFEED : sb.append(BACKSLASH).append('f'); break;
                case NEWLINE : sb.append(BACKSLASH).append('n'); break;
                case RETURN : sb.append(BACKSLASH).append('r'); break;
                case TAB : sb.append(BACKSLASH).append(TAB); break;
                case QUOTE : sb.append(BACKSLASH).append(QUOTE); break;
                case BACKSLASH : sb.append(BACKSLASH).append(BACKSLASH); break;
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
                    case 'b' : sb.append(BACKSPACE); break;
                    case 'f' : sb.append(LINEFEED); break;
                    case 'n' : sb.append(NEWLINE); break;
                    case 'r' : sb.append(RETURN); break;
                    case 't' : sb.append(TAB); break;
                    case QUOTE : sb.append(QUOTE); break;
                    case BACKSLASH : sb.append(BACKSLASH); break;
                    default: sb.append(BACKSLASH).append(c);
                }
                escaped = false;
            } else {
                if (c == BACKSLASH) {
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
        Arrays.fill(chars, TAB);
        return new String(chars);
    }

    public static boolean whitespace(char c) {
        return c == SPACE || c == TAB || c == RETURN || c == NEWLINE;
    }
}
