package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

public class WriterBasedJsonGenerator_writeNumber_45_0_Test {

    private WriterBasedJsonGenerator jsonGenerator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        jsonGenerator = new WriterBasedJsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), writer);
    }

    @Test
    public void testWriteNumberAsString() throws IOException {
        // Assuming _cfgNumbersAsStrings is true
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", true);
        char[] encodedValueBuffer = "1234".toCharArray();
        jsonGenerator.writeNumber(encodedValueBuffer, 0, 4);
        assertEquals("\"1234\"", writer.toString());
    }

    @Test
    public void testWriteNumberAsRaw() throws IOException {
        // Assuming _cfgNumbersAsStrings is false
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", false);
        char[] encodedValueBuffer = "5678".toCharArray();
        jsonGenerator.writeNumber(encodedValueBuffer, 0, 4);
        assertEquals("5678", writer.toString());
    }

    @Test
    public void testWriteNumberWithOffsetAndLength() throws IOException {
        // Assuming _cfgNumbersAsStrings is true
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", true);
        char[] encodedValueBuffer = "98765".toCharArray();
        // Should write "876"
        jsonGenerator.writeNumber(encodedValueBuffer, 1, 3);
        assertEquals("\"876\"", writer.toString());
    }

    @Test
    public void testWriteNumberThrowsIOException() {
        // Simulate an IOException
        assertThrows(IOException.class, () -> {
            doThrow(new IOException("Writer error")).when(writer).write(anyString());
            char[] encodedValueBuffer = "1234".toCharArray();
            jsonGenerator.writeNumber(encodedValueBuffer, 0, 4);
        });
    }

    @Test
    public void testWriteNumberWithInvalidOffset() {
        // Assuming _cfgNumbersAsStrings is true
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", true);
        char[] encodedValueBuffer = "12345".toCharArray();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid offset
            jsonGenerator.writeNumber(encodedValueBuffer, 5, 1);
        });
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            // Fixed line: use Field instead of var
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
