package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class SimpleCharStream_GetSuffix_19_0_Test {

    private SimpleCharStream simpleCharStream;

    @BeforeEach
    void setUp() {
        // Create a StringReader as input stream and set buffer size appropriately
        String input = "Hello, World!";
        simpleCharStream = new SimpleCharStream(new StringReader(input), 1, 1, 1);
        simpleCharStream.buffer = input.toCharArray();
        // Set to the last position
        simpleCharStream.bufpos = input.length() - 1;
    }

    @Test
    void testGetSuffixWithBufferSizeGreaterThanPosition() {
        char[] expected = { '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!', '!' };
        char[] actual = simpleCharStream.GetSuffix(15);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testGetSuffixWithExactBufferSize() {
        char[] expected = { 'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!', '!' };
        char[] actual = simpleCharStream.GetSuffix(14);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testGetSuffixWithBufferSizeLessThanPosition() {
        char[] expected = { 'W', 'o', 'r', 'l', 'd', '!' };
        char[] actual = simpleCharStream.GetSuffix(6);
        assertArrayEquals(expected, actual);
    }
}
