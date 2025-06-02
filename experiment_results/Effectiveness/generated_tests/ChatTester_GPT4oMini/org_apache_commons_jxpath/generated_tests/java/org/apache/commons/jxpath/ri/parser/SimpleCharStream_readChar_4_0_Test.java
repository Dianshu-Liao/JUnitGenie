package org.apache.commons.jxpath.ri.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SimpleCharStream_readChar_4_0_Test {

    private SimpleCharStream simpleCharStream;

    private Reader reader;

    @BeforeEach
    public void setUp() {
        reader = new StringReader("Hello");
        simpleCharStream = new SimpleCharStream(reader);
        // Manually set buffer and related fields for testing
        simpleCharStream.buffer = new char[] { 'H', 'e', 'l', 'l', 'o' };
        simpleCharStream.bufsize = 5;
        simpleCharStream.maxNextCharInd = 5;
        simpleCharStream.inBuf = 0;
        simpleCharStream.bufpos = -1;
    }

    @Test
    public void testReadCharFromBuffer() throws IOException {
        // Fill in the buffer to simulate reading from it
        // Simulate that we have 5 chars available
        simpleCharStream.inBuf = 5;
        char result = simpleCharStream.readChar();
        assertEquals('H', result);
        assertEquals(0, simpleCharStream.bufpos);
    }

    @Test
    public void testReadCharFromInputStream() throws IOException {
        // Simulate that the buffer is empty
        simpleCharStream.inBuf = 0;
        char result = simpleCharStream.readChar();
        assertEquals('H', result);
        assertEquals(0, simpleCharStream.bufpos);
    }

    @Test
    public void testReadCharWrapAround() throws IOException {
        // Simulate that we have 5 chars available
        simpleCharStream.inBuf = 5;
        // Read first char
        simpleCharStream.readChar();
        // Read second char
        simpleCharStream.readChar();
        // Should be at position 1
        assertEquals(1, simpleCharStream.bufpos);
        // Read third char
        simpleCharStream.readChar();
        // Read fourth char
        simpleCharStream.readChar();
        // Read fifth char
        simpleCharStream.readChar();
        // Should wrap around
        char result = simpleCharStream.readChar();
        // Should return 'H' again
        assertEquals('H', result);
        // Should be back at position 0
        assertEquals(0, simpleCharStream.bufpos);
    }

    @Test
    public void testReadCharThrowsIOException() {
        // Create a reader that throws IOException
        Reader faultyReader = Mockito.mock(Reader.class);
        try {
            Mockito.when(faultyReader.read()).thenThrow(new IOException("Read error"));
            simpleCharStream = new SimpleCharStream(faultyReader);
            assertThrows(IOException.class, () -> simpleCharStream.readChar());
        } catch (IOException e) {
            fail("Unexpected IOException thrown: " + e.getMessage());
        }
    }

    @Test
    public void testReadCharUpdatesLineAndColumn() throws IOException {
        // Assuming UpdateLineColumn updates the line and column correctly
        // Simulate that we have 5 chars available
        simpleCharStream.inBuf = 5;
        char result = simpleCharStream.readChar();
        assertEquals('H', result);
        // Assuming line stays the same
        assertEquals(1, simpleCharStream.line);
        // Assuming column increments
        assertEquals(1, simpleCharStream.column);
    }
}
