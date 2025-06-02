package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

public class CharTypes_get7BitOutputEscapes_8_0_Test {

    @BeforeEach
    public void setUp() {
        // No need to set up AltEscapes as it cannot be mocked or accessed
    }

    @Test
    public void testGet7BitOutputEscapesWithQuoteCharAndEscapeSlash() {
        int quoteChar = '"';
        boolean escapeSlash = true;
        int[] result = CharTypes.get7BitOutputEscapes(quoteChar, escapeSlash);
        assertArrayEquals(CharTypes.sOutputEscapes128WithSlash, result);
    }

    @Test
    public void testGet7BitOutputEscapesWithQuoteCharAndNoEscapeSlash() {
        int quoteChar = '"';
        boolean escapeSlash = false;
        int[] result = CharTypes.get7BitOutputEscapes(quoteChar, escapeSlash);
        assertArrayEquals(CharTypes.sOutputEscapes128, result);
    }

    @Test
    public void testGet7BitOutputEscapesWithNonQuoteCharAndEscapeSlash() {
        int quoteChar = 'a';
        boolean escapeSlash = true;
        // Assuming a default expected escape array for non-quote characters
        // This should match the expected behavior
        int[] expectedEscapes = { 1, 2, 3 };
        int[] result = CharTypes.get7BitOutputEscapes(quoteChar, escapeSlash);
        assertArrayEquals(expectedEscapes, result);
    }

    @Test
    public void testGet7BitOutputEscapesWithNonQuoteCharAndNoEscapeSlash() {
        int quoteChar = 'b';
        boolean escapeSlash = false;
        // Assuming a default expected escape array for non-quote characters
        // This should match the expected behavior
        int[] expectedEscapes = { 4, 5, 6 };
        int[] result = CharTypes.get7BitOutputEscapes(quoteChar, escapeSlash);
        assertArrayEquals(expectedEscapes, result);
    }
}
