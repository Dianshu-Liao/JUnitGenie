package org.apache.commons.jxpath.ri.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
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
        // Initialize with a sample input stream
        String input = "Hello, World!";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        simpleCharStream = new SimpleCharStream(byteArrayInputStream, 1, 1, 1024);
        // Setting up internal state for testing
        try {
            // Simulate the internal buffer and positions
            simpleCharStream.buffer = input.toCharArray();
            simpleCharStream.tokenBegin = 0;
            // Last character index of "Hello, World!"
            simpleCharStream.bufpos = 12;
            simpleCharStream.bufsize = input.length();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetImage_WithValidBufferPosition() {
        String expected = "Hello, World!";
        String actual = simpleCharStream.GetImage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetImage_WithWrapAroundBuffer() {
        // Start from 'W'
        simpleCharStream.tokenBegin = 10;
        // End at 'o'
        simpleCharStream.bufpos = 5;
        String expected = "World!Hello";
        String actual = simpleCharStream.GetImage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetImage_WhenTokenBeginIsGreaterThanBufpos() {
        // Start from 'o'
        simpleCharStream.tokenBegin = 5;
        // End at 'l'
        simpleCharStream.bufpos = 4;
        String expected = "o";
        String actual = simpleCharStream.GetImage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetImage_WhenBufferIsEmpty() {
        simpleCharStream.buffer = new char[0];
        simpleCharStream.tokenBegin = 0;
        simpleCharStream.bufpos = -1;
        String expected = "";
        String actual = simpleCharStream.GetImage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetImage_WhenBufferIsNull() {
        simpleCharStream.buffer = null;
        simpleCharStream.tokenBegin = 0;
        simpleCharStream.bufpos = -1;
        assertThrows(NullPointerException.class, () -> {
            simpleCharStream.GetImage();
        });
    }
}
