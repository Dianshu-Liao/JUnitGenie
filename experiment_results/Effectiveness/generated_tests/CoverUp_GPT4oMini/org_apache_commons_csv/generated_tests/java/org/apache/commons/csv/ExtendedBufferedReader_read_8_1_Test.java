package org.apache.commons.csv;

import java.io.IOException;
import java.io.StringReader;
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
import java.io.Reader;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.UnsynchronizedBufferedReader;

class ExtendedBufferedReader_read_8_1_Test {

    private ExtendedBufferedReader reader;

    @BeforeEach
    void setUp() {
        reader = new ExtendedBufferedReader(new StringReader("Hello\nWorld\n"), Charset.defaultCharset(), true);
    }

    @Test
    void testReadWithValidInput() throws IOException {
        char[] buffer = new char[10];
        int bytesRead = reader.read(buffer, 0, 10);
        assertEquals(10, bytesRead);
        assertEquals("Hello\nWorl", new String(buffer, 0, bytesRead));
        // Line number should be incremented
        assertEquals(1, reader.getLineNumber());
        // Position should be updated
        assertEquals(10, reader.getPosition());
    }

    @Test
    void testReadWithPartialLine() throws IOException {
        char[] buffer = new char[5];
        int bytesRead = reader.read(buffer, 0, 5);
        assertEquals(5, bytesRead);
        assertEquals("Hello", new String(buffer, 0, bytesRead));
        // Line number should remain the same
        assertEquals(1, reader.getLineNumber());
    }

    @Test
    void testReadWithLineBreak() throws IOException {
        char[] buffer = new char[10];
        // Read "Hello\nWorl"
        reader.read(buffer, 0, 10);
        // Read "d"
        int bytesRead = reader.read(buffer, 0, 10);
        assertEquals(1, bytesRead);
        assertEquals("d", new String(buffer, 0, bytesRead));
        // Line number should increment
        assertEquals(2, reader.getLineNumber());
    }

    @Test
    void testReadWithZeroLength() throws IOException {
        char[] buffer = new char[10];
        int bytesRead = reader.read(buffer, 0, 0);
        assertEquals(0, bytesRead);
        // Position should not change
        assertEquals(0, reader.getPosition());
    }

    @Test
    void testReadEOF() throws IOException {
        char[] buffer = new char[10];
        // Read "Hello\nWorl"
        reader.read(buffer, 0, 10);
        // Read "d"
        int bytesRead = reader.read(buffer, 0, 10);
        // Read EOF
        bytesRead = reader.read(buffer, 0, 10);
        // EOF should return -1
        assertEquals(-1, bytesRead);
        // Line number should remain the same
        assertEquals(2, reader.getLineNumber());
    }

    @Test
    void testReadOutOfBounds() {
        char[] buffer = new char[10];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid offset
            reader.read(buffer, -1, 10);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid length
            reader.read(buffer, 0, -1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid offset
            reader.read(buffer, 11, 10);
        });
    }
}
