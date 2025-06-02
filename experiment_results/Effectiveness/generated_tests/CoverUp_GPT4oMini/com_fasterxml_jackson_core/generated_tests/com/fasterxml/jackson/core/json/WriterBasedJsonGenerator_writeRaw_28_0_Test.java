package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class WriterBasedJsonGenerator_writeRaw_28_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        ioContext = mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, mock(ObjectCodec.class), writer);
    }

    @Test
    public void testWriteRawWithValidSerializableString() throws Exception {
        SerializableString serializableString = mock(SerializableString.class);
        when(serializableString.appendUnquoted(any(char[].class), anyInt())).thenReturn(5);
        when(serializableString.getValue()).thenReturn("test");
        // Invoke the focal method
        generator.writeRaw(serializableString);
        // Verify the output
        assertEquals("test", writer.toString());
    }

    @Test
    public void testWriteRawWithNegativeLength() throws Exception {
        SerializableString serializableString = mock(SerializableString.class);
        when(serializableString.appendUnquoted(any(char[].class), anyInt())).thenReturn(-1);
        when(serializableString.getValue()).thenReturn("fallback");
        // Invoke the focal method
        generator.writeRaw(serializableString);
        // Verify the output
        assertEquals("fallback", writer.toString());
    }

    @Test
    public void testWriteRawWithEmptySerializableString() throws Exception {
        SerializableString serializableString = mock(SerializableString.class);
        when(serializableString.appendUnquoted(any(char[].class), anyInt())).thenReturn(0);
        // Invoke the focal method
        generator.writeRaw(serializableString);
        // Verify that nothing was written
        assertEquals("", writer.toString());
    }

    @Test
    public void testWriteRawWithException() throws Exception {
        SerializableString serializableString = mock(SerializableString.class);
        when(serializableString.appendUnquoted(any(char[].class), anyInt())).thenThrow(new IOException("Test Exception"));
        // Capture the exception
        try {
            generator.writeRaw(serializableString);
        } catch (IOException e) {
            assertEquals("Test Exception", e.getMessage());
        }
    }

    @Test
    public void testGetHexChars() throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("getHexChars");
        method.setAccessible(true);
        char[] hexChars = (char[]) method.invoke(generator);
        // Check if hex chars are correctly initialized
        assertEquals(16, hexChars.length);
    }
}
