package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.ExtendedBufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;

class Lexer_isDelimiter_8_0_Test {

    private ExtendedBufferedReader reader;

    private Lexer lexer;

    @BeforeEach
    void setUp() {
        CSVFormat format = CSVFormat.DEFAULT.builder().setDelimiter(',').get();
        reader = new ExtendedBufferedReader(new StringReader("test,data\n"));
        lexer = new Lexer(format, reader);
    }

    @Test
    void testIsDelimiterReturnsTrueForSingleDelimiter() throws Exception {
        // Set the delimiter to a single character
        Method setDelimiterMethod = Lexer.class.getDeclaredMethod("setDelimiter", char[].class);
        setDelimiterMethod.setAccessible(true);
        setDelimiterMethod.invoke(lexer, new char[] { ',' });
        assertTrue(invokeIsDelimiter(lexer, ','));
    }

    @Test
    void testIsDelimiterReturnsFalseForDifferentCharacter() throws Exception {
        // Set the delimiter to a single character
        Method setDelimiterMethod = Lexer.class.getDeclaredMethod("setDelimiter", char[].class);
        setDelimiterMethod.setAccessible(true);
        setDelimiterMethod.invoke(lexer, new char[] { ',' });
        assertFalse(invokeIsDelimiter(lexer, ';'));
    }

    @Test
    void testIsDelimiterReturnsTrueForMultiCharacterDelimiter() throws Exception {
        // Set the delimiter to multiple characters
        Method setDelimiterMethod = Lexer.class.getDeclaredMethod("setDelimiter", char[].class);
        setDelimiterMethod.setAccessible(true);
        setDelimiterMethod.invoke(lexer, new char[] { ',', ' ' });
        // Simulate reading the delimiter from the reader
        // Read the space character
        reader.read(new char[] { ' ', ' ' }, 0, 2);
        assertTrue(invokeIsDelimiter(lexer, ','));
    }

    @Test
    void testIsDelimiterReturnsFalseForIncorrectMultiCharacterDelimiter() throws Exception {
        // Set the delimiter to multiple characters
        Method setDelimiterMethod = Lexer.class.getDeclaredMethod("setDelimiter", char[].class);
        setDelimiterMethod.setAccessible(true);
        setDelimiterMethod.invoke(lexer, new char[] { ',', ' ' });
        // Simulate reading a different character
        // Read some non-delimiter characters
        reader.read(new char[] { 'a', 'b' }, 0, 2);
        assertFalse(invokeIsDelimiter(lexer, ','));
    }

    private boolean invokeIsDelimiter(Lexer lexer, int ch) throws Exception {
        Method isDelimiterMethod = Lexer.class.getDeclaredMethod("isDelimiter", int.class);
        isDelimiterMethod.setAccessible(true);
        return (boolean) isDelimiterMethod.invoke(lexer, ch);
    }
}
