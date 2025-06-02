package org.apache.commons.jxpath.ri.parser;

import java.io.IOException;
import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SimpleCharStream_readChar_4_0_Test {

    private SimpleCharStream charStream;

    @BeforeEach
    public void setUp() {
        String input = "Hello\nWorld!";
        charStream = new SimpleCharStream(new StringReader(input), 1, 1);
    }

    @Test
    public void testReadCharNormal() throws IOException {
        assertEquals('H', charStream.readChar());
        assertEquals('e', charStream.readChar());
        assertEquals('l', charStream.readChar());
        assertEquals('l', charStream.readChar());
        assertEquals('o', charStream.readChar());
    }

    @Test
    public void testReadCharNewLine() throws IOException {
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
        assertEquals('W', charStream.readChar());
    }

    @Test
    public void testReadCharBufferWrap() throws IOException {
        for (int i = 0; i < 10; i++) {
            // Read characters until buffer is filled
            charStream.readChar();
        }
        // Read last character
        assertEquals('!', charStream.readChar());
    }

    @Test
    public void testReadCharEndOfStream() throws IOException {
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
        // Read 'W'
        charStream.readChar();
        // Read 'o'
        charStream.readChar();
        // Read 'r'
        charStream.readChar();
        // Read 'l'
        charStream.readChar();
        // Read 'd'
        charStream.readChar();
        // Read '!'
        charStream.readChar();
        // Expect IOException
        assertThrows(IOException.class, () -> charStream.readChar());
    }

    @Test
    public void testReadCharWithEmptyBuffer() throws IOException {
        charStream = new SimpleCharStream(new StringReader(""), 1, 1);
        // Expect IOException on empty stream
        assertThrows(IOException.class, () -> charStream.readChar());
    }
}
