package org.apache.commons.jxpath.ri.parser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SimpleCharStream_GetSuffix_19_0_Test {

    private SimpleCharStream simpleCharStream;

    private char[] buffer;

    @BeforeEach
    public void setUp() {
        String input = "Hello, World!";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        simpleCharStream = new SimpleCharStream(inputStream, 1, 1, 20);
        simpleCharStream.buffer = input.toCharArray();
        // Set position to the end of buffer
        simpleCharStream.bufpos = 12;
        simpleCharStream.bufsize = 20;
    }

    @Test
    public void testGetSuffixWithSufficientLength() {
        int len = 5;
        char[] expected = { ' ', 'W', 'o', 'r', 'l' };
        char[] actual = simpleCharStream.GetSuffix(len);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSuffixWithExactLength() {
        int len = 13;
        char[] expected = { 'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!' };
        char[] actual = simpleCharStream.GetSuffix(len);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSuffixWithLengthGreaterThanBuffer() {
        int len = 15;
        char[] expected = { 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!', 'H', 'e', 'l', 'l', 'o', ' ' };
        char[] actual = simpleCharStream.GetSuffix(len);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSuffixWithZeroLength() {
        int len = 0;
        char[] expected = {};
        char[] actual = simpleCharStream.GetSuffix(len);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSuffixWithNegativeLength() {
        int len = -1;
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            simpleCharStream.GetSuffix(len);
        });
    }
}
