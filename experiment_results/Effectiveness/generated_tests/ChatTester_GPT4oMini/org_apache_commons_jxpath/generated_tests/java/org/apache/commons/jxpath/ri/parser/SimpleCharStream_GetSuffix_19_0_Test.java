package org.apache.commons.jxpath.ri.parser;

import java.io.CharArrayReader;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SimpleCharStream_GetSuffix_19_0_Test {

    private SimpleCharStream simpleCharStream;

    @BeforeEach
    public void setUp() {
        // Initialize buffer with some test data
        String testInput = "Hello, World!";
        simpleCharStream = new SimpleCharStream(new CharArrayReader(testInput.toCharArray()), 1, 1, 20);
        // Set the buffer directly for testing
        simpleCharStream.buffer = testInput.toCharArray();
        simpleCharStream.bufsize = testInput.length();
        // Set position to the end of the input
        simpleCharStream.bufpos = testInput.length() - 1;
    }

    @Test
    public void testGetSuffix_withValidLength() {
        char[] expected = { '!', ' ' };
        char[] actual = simpleCharStream.GetSuffix(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSuffix_withLengthGreaterThanBufferPosition() {
        char[] expected = { 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!', 'H', 'e', 'l', 'l' };
        char[] actual = simpleCharStream.GetSuffix(12);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSuffix_withExactBufferSize() {
        char[] expected = { 'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!' };
        char[] actual = simpleCharStream.GetSuffix(13);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSuffix_withZeroLength() {
        char[] expected = {};
        char[] actual = simpleCharStream.GetSuffix(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSuffix_withNegativeLength() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            simpleCharStream.GetSuffix(-1);
        });
    }
}
