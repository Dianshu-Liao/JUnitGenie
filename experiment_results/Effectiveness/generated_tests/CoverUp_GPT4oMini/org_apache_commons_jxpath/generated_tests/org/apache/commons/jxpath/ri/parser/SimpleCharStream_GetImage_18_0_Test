package org.apache.commons.jxpath.ri.parser;

import java.io.IOException;
import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SimpleCharStream_GetImage_18_0_Test {

    private SimpleCharStream simpleCharStream;

    @BeforeEach
    public void setUp() {
        // Initialize with a StringReader for testing
        simpleCharStream = new SimpleCharStream(new StringReader("Hello World"), 1, 1, 1024);
    }

    @Test
    public void testGetImageWithBufferPositionGreaterThanTokenBegin() {
        // Simulate reading characters to set bufpos and tokenBegin
        try {
            // This sets tokenBegin
            simpleCharStream.BeginToken();
            // Move bufpos to 0
            simpleCharStream.readChar();
            // Move bufpos to 1
            simpleCharStream.readChar();
            // Now bufpos is 1 and tokenBegin is 0
            String image = simpleCharStream.GetImage();
            // Expecting "He"
            assertEquals("He", image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetImageWithBufferPositionLessThanTokenBegin() {
        // Simulate reading characters to set bufpos and tokenBegin
        try {
            // This sets tokenBegin
            simpleCharStream.BeginToken();
            // Move bufpos to 0
            simpleCharStream.readChar();
            // Simulate wrapping around
            // Move bufpos back to -1 (wrap around)
            simpleCharStream.backup(1);
            String image = simpleCharStream.GetImage();
            // Expecting full buffer
            assertEquals("Hello World", image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetImageWithEmptyBuffer() {
        // Test case when buffer is empty
        simpleCharStream.bufpos = -1;
        simpleCharStream.tokenBegin = 0;
        String image = simpleCharStream.GetImage();
        // Expecting empty string
        assertEquals("", image);
    }

    @Test
    public void testGetImageWithSingleCharacter() {
        // Test case for single character
        try {
            // This sets tokenBegin
            simpleCharStream.BeginToken();
            // Move bufpos to 0
            simpleCharStream.readChar();
            String image = simpleCharStream.GetImage();
            // Expecting "H"
            assertEquals("H", image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetImageWithNullBuffer() {
        // Test case for null buffer
        simpleCharStream.buffer = null;
        assertThrows(NullPointerException.class, () -> {
            simpleCharStream.GetImage();
        });
    }
}
