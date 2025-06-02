// Test method
package org.apache.commons.csv;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Lexer_readEscape_20_0_Test {

    private Lexer lexer;

    private ExtendedBufferedReader reader;

    @BeforeEach
    void setUp() {
        CSVFormat format = mock(CSVFormat.class);
        reader = mock(ExtendedBufferedReader.class);
        lexer = new Lexer(format, reader);
    }

    @Test
    void testReadEscape_ReturnsCR_WhenInputIsR() throws IOException {
        // Fixed: cast char to int
        when(reader.read()).thenReturn((int) 'r');
        int result = invokeReadEscape(lexer);
        assertEquals(Constants.CR, result);
    }

    @Test
    void testReadEscape_ReturnsLF_WhenInputIsN() throws IOException {
        // Fixed: cast char to int
        when(reader.read()).thenReturn((int) 'n');
        int result = invokeReadEscape(lexer);
        assertEquals(Constants.LF, result);
    }

    @Test
    void testReadEscape_ReturnsTAB_WhenInputIsT() throws IOException {
        // Fixed: cast char to int
        when(reader.read()).thenReturn((int) 't');
        int result = invokeReadEscape(lexer);
        assertEquals(Constants.TAB, result);
    }

    @Test
    void testReadEscape_ReturnsBACKSPACE_WhenInputIsB() throws IOException {
        // Fixed: cast char to int
        when(reader.read()).thenReturn((int) 'b');
        int result = invokeReadEscape(lexer);
        assertEquals(Constants.BACKSPACE, result);
    }

    @Test
    void testReadEscape_ReturnsFF_WhenInputIsF() throws IOException {
        // Fixed: cast char to int
        when(reader.read()).thenReturn((int) 'f');
        int result = invokeReadEscape(lexer);
        assertEquals(Constants.FF, result);
    }

    @Test
    void testReadEscape_ThrowsCSVException_WhenInputIsEOF() throws IOException {
        when(reader.read()).thenReturn(-1);
        Exception exception = assertThrows(CSVException.class, () -> {
            invokeReadEscape(lexer);
        });
        assertEquals("EOF while processing escape sequence", exception.getMessage());
    }

    @Test
    void testReadEscape_ReturnsMetaChar_WhenInputIsMetaChar() throws IOException {
        int metaChar = 'm';
        when(reader.read()).thenReturn(metaChar);
        // Using reflection to access private method
        int result = invokeReadEscape(lexer);
        assertEquals(metaChar, result);
    }

    @Test
    void testReadEscape_ReturnsEOF_WhenInputIsUnexpected() throws IOException {
        // Fixed: cast char to int
        when(reader.read()).thenReturn((int) 'x');
        int result = invokeReadEscape(lexer);
        // Assuming EOF is represented by -1
        assertEquals(-1, result);
    }

    private int invokeReadEscape(Lexer lexer) {
        try {
            // Fixed: changed 'var' to 'Method'
            java.lang.reflect.Method method = Lexer.class.getDeclaredMethod("readEscape");
            method.setAccessible(true);
            return (int) method.invoke(lexer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
