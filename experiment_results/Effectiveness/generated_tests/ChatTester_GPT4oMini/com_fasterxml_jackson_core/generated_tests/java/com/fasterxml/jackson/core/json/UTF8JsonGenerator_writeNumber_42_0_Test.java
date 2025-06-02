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

public class UTF8JsonGenerator_writeNumber_42_0_Test {

    private UTF8JsonGenerator jsonGenerator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        jsonGenerator = new UTF8JsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    public void testWriteNumberAsString() throws Exception {
        // Arrange
        char[] encodedValueBuffer = "123".toCharArray();
        int offset = 0;
        int length = encodedValueBuffer.length;
        // Use reflection to set _cfgNumbersAsStrings to true
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", true);
        // Act
        jsonGenerator.writeNumber(encodedValueBuffer, offset, length);
        // Assert
        String result = outputStream.toString("UTF-8");
        assertEquals("\"123\"", result);
    }

    @Test
    public void testWriteNumberAsRaw() throws Exception {
        // Arrange
        char[] encodedValueBuffer = "123".toCharArray();
        int offset = 0;
        int length = encodedValueBuffer.length;
        // Use reflection to set _cfgNumbersAsStrings to false
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", false);
        // Act
        jsonGenerator.writeNumber(encodedValueBuffer, offset, length);
        // Assert
        String result = outputStream.toString("UTF-8");
        assertEquals("123", result);
    }

    @Test
    public void testWriteNumberHandlesIOException() throws Exception {
        // Arrange
        char[] encodedValueBuffer = "123".toCharArray();
        int offset = 0;
        int length = encodedValueBuffer.length;
        // Mock the OutputStream to throw an IOException
        OutputStream mockOutputStream = mock(OutputStream.class);
        jsonGenerator = new UTF8JsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), mockOutputStream, '"');
        doThrow(new IOException("Test Exception")).when(mockOutputStream).write(any(byte[].class), anyInt(), anyInt());
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonGenerator.writeNumber(encodedValueBuffer, offset, length);
        });
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
