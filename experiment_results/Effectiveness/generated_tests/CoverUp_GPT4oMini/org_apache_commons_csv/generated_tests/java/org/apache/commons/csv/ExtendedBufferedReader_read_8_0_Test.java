package org.apache.commons.csv;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.csv.Constants.CR;
import static org.apache.commons.csv.Constants.LF;
import static org.apache.commons.csv.Constants.UNDEFINED;
import static org.apache.commons.io.IOUtils.EOF;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.UnsynchronizedBufferedReader;

class ExtendedBufferedReader_read_8_0_Test {

    private ExtendedBufferedReader reader;

    @BeforeEach
    void setUp() {
        Reader stringReader = new StringReader("Hello\nWorld\r\n");
        reader = new ExtendedBufferedReader(stringReader, Charset.defaultCharset(), true);
    }

    @Test
    void testReadWithValidInput() throws Exception {
        char[] buffer = new char[10];
        int bytesRead = reader.read(buffer, 0, 10);
        assertEquals(10, bytesRead);
        assertEquals("Hello\nWorl", new String(buffer, 0, bytesRead));
        assertEquals(1, invokeGetLineNumber());
        assertEquals(10, invokeGetPosition());
    }

    @Test
    void testReadWithEmptyBuffer() throws Exception {
        char[] buffer = new char[10];
        int bytesRead = reader.read(buffer, 0, 0);
        assertEquals(0, bytesRead);
        assertEquals(0, invokeGetLineNumber());
        assertEquals(0, invokeGetPosition());
    }

    @Test
    void testReadWithEndOfFile() throws Exception {
        char[] buffer = new char[10];
        // Read the first 10 chars
        reader.read(buffer, 0, 10);
        // Attempt to read more
        int bytesRead = reader.read(buffer, 0, 10);
        // EOF returns -1
        assertEquals(-1, bytesRead);
        // Two lines read
        assertEquals(2, invokeGetLineNumber());
        assertEquals(10, invokeGetPosition());
    }

    @Test
    void testReadWithOffsetAndLength() throws Exception {
        char[] buffer = new char[10];
        int bytesRead = reader.read(buffer, 0, 5);
        bytesRead += reader.read(buffer, 5, 5);
        assertEquals(10, bytesRead);
        assertEquals("Hello\nWorl", new String(buffer, 0, bytesRead));
        assertEquals(1, invokeGetLineNumber());
        assertEquals(10, invokeGetPosition());
    }

    @Test
    void testReadHandlesCRLF() throws Exception {
        char[] buffer = new char[10];
        // Read "Hello\nWorl"
        reader.read(buffer, 0, 10);
        // One line read
        assertEquals(1, invokeGetLineNumber());
        assertEquals(10, invokeGetPosition());
    }

    @Test
    void testReadHandlesOnlyCR() throws Exception {
        Reader stringReader = new StringReader("Hello\rWorld");
        reader = new ExtendedBufferedReader(stringReader, Charset.defaultCharset(), true);
        char[] buffer = new char[10];
        int bytesRead = reader.read(buffer, 0, 10);
        assertEquals(10, bytesRead);
        assertEquals("Hello\rWorl", new String(buffer, 0, bytesRead));
        // Two lines read
        assertEquals(2, invokeGetLineNumber());
    }

    private long invokeGetLineNumber() throws Exception {
        Method method = ExtendedBufferedReader.class.getDeclaredMethod("getLineNumber");
        method.setAccessible(true);
        return (long) method.invoke(reader);
    }

    private long invokeGetPosition() throws Exception {
        Method method = ExtendedBufferedReader.class.getDeclaredMethod("getPosition");
        method.setAccessible(true);
        return (long) method.invoke(reader);
    }
}
