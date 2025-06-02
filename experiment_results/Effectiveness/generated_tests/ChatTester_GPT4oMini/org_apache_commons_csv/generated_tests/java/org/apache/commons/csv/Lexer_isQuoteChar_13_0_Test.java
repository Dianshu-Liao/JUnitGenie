package org.apache.commons.csv;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.Closeable;
import java.io.IOException;
// Added import for StringReader
import java.io.StringReader;
import org.apache.commons.io.IOUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

final class Lexer_isQuoteChar_13_0_Test {

    private Lexer lexer;

    @BeforeEach
    void setUp() {
        // Correctly initialize CSVFormat and ExtendedBufferedReader
        // Use default format
        CSVFormat format = CSVFormat.DEFAULT;
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(""));
        lexer = new Lexer(format, reader);
        // Using reflection to set the private field quoteChar
        try {
            java.lang.reflect.Field quoteCharField = Lexer.class.getDeclaredField("quoteChar");
            quoteCharField.setAccessible(true);
            // Set quoteChar to the double quote character
            quoteCharField.setInt(lexer, '"');
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set up test: " + e.getMessage());
        }
    }

    @Test
    void testIsQuoteChar_WithQuoteCharacter_ReturnsTrue() {
        assertTrue(lexer.isQuoteChar('"'), "Expected isQuoteChar to return true for quote character");
    }

    @Test
    void testIsQuoteChar_WithNonQuoteCharacter_ReturnsFalse() {
        assertFalse(lexer.isQuoteChar('a'), "Expected isQuoteChar to return false for non-quote character");
        assertFalse(lexer.isQuoteChar('1'), "Expected isQuoteChar to return false for non-quote character");
        assertFalse(lexer.isQuoteChar(' '), "Expected isQuoteChar to return false for non-quote character");
    }

    @Test
    void testIsQuoteChar_WithDifferentQuoteCharacter_ReturnsFalse() {
        try {
            // Set quoteChar to a different value
            java.lang.reflect.Field quoteCharField = Lexer.class.getDeclaredField("quoteChar");
            quoteCharField.setAccessible(true);
            // Set quoteChar to single quote character
            quoteCharField.setInt(lexer, '\'');
            assertFalse(lexer.isQuoteChar('"'), "Expected isQuoteChar to return false for a different quote character");
            assertTrue(lexer.isQuoteChar('\''), "Expected isQuoteChar to return true for the new quote character");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set up test: " + e.getMessage());
        }
    }
}
