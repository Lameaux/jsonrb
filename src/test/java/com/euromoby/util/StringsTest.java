package com.euromoby.util;

import org.junit.*;

import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void enquote() {
        assertEquals("\"test\"", Strings.enquote("test"));
    }

    @Test
    public void dequote() {
        assertEquals("test", Strings.dequote("\"test\""));
    }

    @Test
    public void escapeBackspace() {
        assertEquals("\\b", Strings.escape("\b"));
    }

    @Test
    public void escapeFormFeed() {
        assertEquals("\\f", Strings.escape("\f"));
    }

    @Test
    public void escapeNewLine() {
        assertEquals("\\n", Strings.escape("\n"));
    }

    @Test
    public void escapeCarriageReturn() {
        assertEquals("\\r", Strings.escape("\r"));
    }

    @Test
    public void escapeTab() {
        assertEquals("\\t", Strings.escape("\t"));
    }

    @Test
    public void escapeDoubleQuote() {
        assertEquals("\\\"", Strings.escape("\""));
    }

    @Test
    public void escapeBackSlash() {
        assertEquals("\\\\", Strings.escape("\\"));
    }

}
