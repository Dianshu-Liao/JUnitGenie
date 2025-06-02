// Test method
package com.fasterxml.jackson.core.json;

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

public class UTF8JsonGenerator_writeNumber_31_0_Test {

    private UTF8JsonGenerator generator;

    @Mock
    private IOContext context;

    @Mock
    private ObjectCodec codec;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(context, 0, codec, outputStream, '"');
    }

    @Test
    public void testWriteNumber_ShortValue() throws IOException {
        // Prepare the output buffer
        byte[] outputBuffer = new byte[512];
        // Use reflection to set the output buffer and tail
        setPrivateField(generator, "_outputBuffer", outputBuffer);
        setPrivateField(generator, "_outputTail", 0);
        setPrivateField(generator, "_outputEnd", outputBuffer.length);
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        // Call the focal method
        generator.writeNumber((short) 123);
        // Verify the output
        assertArrayEquals(new byte[] { '1', '2', '3' }, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_ShortValueWithFlush() throws IOException {
        // Prepare the output buffer
        // Smaller buffer to trigger flush
        byte[] outputBuffer = new byte[5];
        setPrivateField(generator, "_outputBuffer", outputBuffer);
        setPrivateField(generator, "_outputTail", 0);
        setPrivateField(generator, "_outputEnd", outputBuffer.length);
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        // Call the focal method
        generator.writeNumber((short) 12345);
        // Verify the output
        assertArrayEquals(new byte[] { '1', '2', '3', '4', '5' }, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_ShortValueAsString() throws IOException {
        // Prepare the output buffer
        byte[] outputBuffer = new byte[512];
        setPrivateField(generator, "_outputBuffer", outputBuffer);
        setPrivateField(generator, "_outputTail", 0);
        setPrivateField(generator, "_outputEnd", outputBuffer.length);
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        // Call the focal method
        generator.writeNumber((short) 123);
        // Verify the output for quoted short
        assertArrayEquals(new byte[] { '"', '1', '2', '3', '"' }, outputStream.toByteArray());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            // Fixed line: Changed 'var' to 'Field' for compatibility
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
