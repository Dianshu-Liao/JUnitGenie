package org.apache.commons.jxpath.ri.parser;

import java.io.CharArrayReader;
import java.io.IOException;
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
        // Initialize buffer with some test data
        String testInput = "Hello, World!";
        simpleCharStream = new SimpleCharStream(new CharArrayReader(testInput.toCharArray()));
        simpleCharStream.tokenBegin = 0;
        // Last index of "Hello, World!"
        simpleCharStream.bufpos = 12;
        simpleCharStream.buffer = testInput.toCharArray();
        simpleCharStream.bufsize = testInput.length();
    }

    @Test
    public void testGetImage_ReturnsCorrectString_WhenBufferPositionIsValid() {
        String expected = "Hello, World!";
        String actual = simpleCharStream.GetImage();
        assertEquals(expected, actual, "GetImage should return the correct string when bufpos is valid.");
    }

    @Test
    public void testGetImage_ReturnsWrappedString_WhenBufferPositionIsLessThanTokenBegin() {
        // Start from 'o' in "Hello"
        simpleCharStream.tokenBegin = 5;
        // Position at 'l' in "Hello"
        simpleCharStream.bufpos = 2;
        // Wrap around the buffer
        String expected = "lo, World!Hel";
        String actual = simpleCharStream.GetImage();
        assertEquals(expected, actual, "GetImage should wrap around and return the correct string.");
    }

    @Test
    public void testGetImage_ReturnsEmptyString_WhenBufferIsEmpty() {
        simpleCharStream.buffer = new char[0];
        simpleCharStream.tokenBegin = 0;
        // No valid position
        simpleCharStream.bufpos = -1;
        String expected = "";
        String actual = simpleCharStream.GetImage();
        assertEquals(expected, actual, "GetImage should return an empty string when the buffer is empty.");
    }

    @Test
    public void testGetImage_ReturnsCorrectString_WhenTokenBeginIsEqualToBufpos() {
        // Start from 'o' in "Hello"
        simpleCharStream.tokenBegin = 5;
        // Position at 'o' in "Hello"
        simpleCharStream.bufpos = 5;
        // Should return the character at tokenBegin
        String expected = "o";
        String actual = simpleCharStream.GetImage();
        assertEquals(expected, actual, "GetImage should return the correct string when tokenBegin equals bufpos.");
    }
}
