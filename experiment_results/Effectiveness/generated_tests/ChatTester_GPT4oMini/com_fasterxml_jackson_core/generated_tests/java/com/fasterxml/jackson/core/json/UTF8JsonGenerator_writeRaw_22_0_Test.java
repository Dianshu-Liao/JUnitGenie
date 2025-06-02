// Test method
package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class UTF8JsonGenerator_writeRaw_22_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Assuming IOContext and ObjectCodec are properly mocked or instantiated
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream, '"');
    }

    @Test
    public void testWriteRaw_WithValidInput() throws Exception {
        String input = "Hello, World!";
        int offset = 0;
        int len = input.length();
        // Invoke the focal method using reflection
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeRaw", String.class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, input, offset, len);
        // Verify the output
        String expectedOutput = "Hello, World!";
        assertEquals(expectedOutput, outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteRaw_WithEmptyString() throws Exception {
        String input = "";
        int offset = 0;
        int len = input.length();
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeRaw", String.class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, input, offset, len);
        assertEquals("", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteRaw_WithSurrogatePair() throws Exception {
        // Grinning Face Emoji
        String input = "\uD83D\uDE00";
        int offset = 0;
        int len = input.length();
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeRaw", String.class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, input, offset, len);
        // Validate the output
        assertEquals(input, outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteRaw_WithLargeInput() throws Exception {
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            input.append("Hello, World!");
        }
        int offset = 0;
        int len = input.length();
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeRaw", String.class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, input.toString(), offset, len);
        assertEquals(input.toString(), outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteRaw_WithInvalidRange() throws Exception {
        String input = "Hello";
        int offset = 1;
        // Invalid length
        int len = 10;
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeRaw", String.class, int.class, int.class);
        method.setAccessible(true);
        assertThrows(IOException.class, () -> {
            method.invoke(generator, input, offset, len);
        });
    }

    @Test
    public void testWriteRaw_WithSurrogateSplit() throws Exception {
        // Only the first part of a surrogate pair
        String input = "\uD83D";
        int offset = 0;
        int len = input.length();
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeRaw", String.class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, input, offset, len);
        // Validate that the output does not include the incomplete surrogate
        // No output expected
        assertEquals("", outputStream.toString("UTF-8"));
    }
}
