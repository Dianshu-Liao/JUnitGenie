// Test method
package com.fasterxml.jackson.core.json;

import java.math.BigInteger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
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

public class UTF8JsonGenerator_writeNumber_37_2_Test {

    private UTF8JsonGenerator generator;

    @Mock
    private IOContext ioContext;

    @Mock
    private ObjectCodec objectCodec;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        // Invoke the method
        invokeWriteNumber(generator, null);
        // Check output
        assertEquals("null", outputStream.toString());
    }

    @Test
    public void testWriteNumber_AsString() throws IOException {
        // Set the configuration for numbers as strings
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        // Invoke the method
        invokeWriteNumber(generator, BigInteger.valueOf(123));
        // Check output
        assertEquals("\"123\"", outputStream.toString());
    }

    @Test
    public void testWriteNumber_AsRaw() throws IOException {
        // Ensure the configuration for numbers as strings is false
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        // Invoke the method
        invokeWriteNumber(generator, BigInteger.valueOf(456));
        // Check output
        assertEquals("456", outputStream.toString());
    }

    private void invokeWriteNumber(UTF8JsonGenerator generator, BigInteger value) throws IOException {
        try {
            // Fixed line: replaced 'var' with 'java.lang.reflect.Method'
            java.lang.reflect.Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", BigInteger.class);
            method.setAccessible(true);
            method.invoke(generator, value);
        } catch (ReflectiveOperationException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        // Fixed line: replaced 'var' with 'java.lang.reflect.Field'
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (ReflectiveOperationException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
