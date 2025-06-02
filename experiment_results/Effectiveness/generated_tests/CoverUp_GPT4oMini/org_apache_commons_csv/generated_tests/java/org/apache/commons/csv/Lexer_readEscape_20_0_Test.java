package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.Lexer;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.Closeable;

class Lexer_readEscape_20_0_Test {

    private ExtendedBufferedReader reader;

    private Lexer lexer;

    @BeforeEach
    void setUp() {
        // Use default format for testing
        CSVFormat format = CSVFormat.DEFAULT;
        // Initialize with empty input
        reader = new ExtendedBufferedReader(new StringReader(""));
        lexer = new Lexer(format, reader);
    }

    @Test
    void testReadEscape_ReturnsCR() throws Exception {
        setReaderInput("r");
        assertEquals(Constants.CR, invokeReadEscape());
    }

    @Test
    void testReadEscape_ReturnsLF() throws Exception {
        setReaderInput("n");
        assertEquals(Constants.LF, invokeReadEscape());
    }

    @Test
    void testReadEscape_ReturnsTAB() throws Exception {
        setReaderInput("t");
        assertEquals(Constants.TAB, invokeReadEscape());
    }

    @Test
    void testReadEscape_ReturnsBACKSPACE() throws Exception {
        setReaderInput("b");
        assertEquals(Constants.BACKSPACE, invokeReadEscape());
    }

    @Test
    void testReadEscape_ReturnsFF() throws Exception {
        setReaderInput("f");
        assertEquals(Constants.FF, invokeReadEscape());
    }

    @Test
    void testReadEscape_ReturnsEOF() {
        // Empty input to simulate EOF
        setReaderInput("");
        Exception exception = assertThrows(CSVException.class, () -> invokeReadEscape());
        assertEquals("EOF while processing escape sequence", exception.getMessage());
    }

    @Test
    void testReadEscape_ReturnsUnexpectedChar() throws Exception {
        // An unexpected character
        setReaderInput("x");
        assertEquals(IOUtils.EOF, invokeReadEscape());
    }

    private void setReaderInput(String input) {
        reader = new ExtendedBufferedReader(new StringReader(input));
        lexer = new Lexer(CSVFormat.DEFAULT, reader);
    }

    private int invokeReadEscape() throws Exception {
        Method method = Lexer.class.getDeclaredMethod("readEscape");
        method.setAccessible(true);
        return (int) method.invoke(lexer);
    }
}
