package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;

class Lexer_isMetaChar_12_2_Test {

    private Lexer lexer;

    private ExtendedBufferedReader mockReader;

    @BeforeEach
    void setUp() {
        CSVFormat format = mock(CSVFormat.class);
        mockReader = mock(ExtendedBufferedReader.class);
        lexer = new Lexer(format, mockReader);
    }

    @Test
    void testIsMetaCharWithEscapeChar() throws Exception {
        // Assuming escape character is backslash
        setPrivateField("escape", '\\');
        assertTrue(invokeIsMetaChar('\\'));
    }

    @Test
    void testIsMetaCharWithQuoteChar() throws Exception {
        // Assuming quote character is double quote
        setPrivateField("quoteChar", '"');
        assertTrue(invokeIsMetaChar('"'));
    }

    @Test
    void testIsMetaCharWithCommentStartChar() throws Exception {
        // Assuming comment start character is hash
        setPrivateField("commentStart", '#');
        assertTrue(invokeIsMetaChar('#'));
    }

    @Test
    void testIsMetaCharWithNonMetaChar() throws Exception {
        // 'a' is not a meta character
        assertFalse(invokeIsMetaChar('a'));
    }

    private boolean invokeIsMetaChar(int ch) throws Exception {
        java.lang.reflect.Method method = Lexer.class.getDeclaredMethod("isMetaChar", int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(lexer, ch);
    }

    private void setPrivateField(String fieldName, int value) throws Exception {
        java.lang.reflect.Field field = Lexer.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(lexer, value);
    }
}
