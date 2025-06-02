package org.apache.commons.jxpath.ri.parser;

import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import java.io.IOException;
import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class SimpleCharStream_readChar_4_0_Test {

    private SimpleCharStream charStream;

    @BeforeEach
    void setUp() {
        StringReader stringReader = new StringReader("Hello\nWorld");
        charStream = new SimpleCharStream(stringReader, 1, 1, 10);
    }

    @Test
    void testReadCharFromBuffer() throws IOException {
        // Read 'H'
        charStream.readChar();
        // Read 'e'
        char result = charStream.readChar();
        assertEquals('e', result);
    }

    @Test
    void testReadCharFillsBuffer() throws IOException {
        // Reading characters to fill the buffer
        for (int i = 0; i < 5; i++) {
            charStream.readChar();
        }
        // Should read '\n'
        char result = charStream.readChar();
        assertEquals('\n', result);
    }

    @Test
    void testReadCharUpdatesLineAndColumn() throws IOException {
        // Read 'H'
        charStream.readChar();
        // Read 'e'
        charStream.readChar();
        // Read 'l'
        charStream.readChar();
        // Read 'l'
        charStream.readChar();
        // Read 'o'
        charStream.readChar();
        // Read '\n'
        charStream.readChar();
        // Now we should be at the next line
        // Read 'W'
        charStream.readChar();
        assertEquals(2, charStream.getLine());
        assertEquals(1, charStream.getColumn());
    }

    @Test
    void testReadCharThrowsIOExceptionOnEmptyStream() throws IOException {
        charStream = new SimpleCharStream(new StringReader(""), 1, 1, 10);
        assertThrows(IOException.class, charStream::readChar);
    }

    @Test
    void testReadCharHandlesCRLF() throws IOException {
        charStream = new SimpleCharStream(new StringReader("Hello\r\nWorld"), 1, 1, 10);
        // Read 'H'
        charStream.readChar();
        // Read 'e'
        charStream.readChar();
        // Read 'l'
        charStream.readChar();
        // Read 'l'
        charStream.readChar();
        // Read 'o'
        charStream.readChar();
        // Read '\r'
        charStream.readChar();
        // Read '\n'
        charStream.readChar();
        // Now we should be at the next line
        // Read 'W'
        charStream.readChar();
        assertEquals(2, charStream.getLine());
        assertEquals(1, charStream.getColumn());
    }
}
