package com.fasterxml.jackson.core.json;

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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeRaw_21_1_Test {

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
    public void testWriteRaw_WithShortText() throws Exception {
        String text = "Hello";
        invokeWriteRaw(text);
        assertEquals("Hello", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteRaw_WithLongText() throws Exception {
        String text = "This is a long text that exceeds the buffer size limit.";
        invokeWriteRaw(text);
        assertEquals(text, outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteRaw_WithEmptyText() throws Exception {
        String text = "";
        invokeWriteRaw(text);
        assertEquals("", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteRaw_WithNullText() {
        assertThrows(NullPointerException.class, () -> {
            invokeWriteRaw(null);
        });
    }

    private void invokeWriteRaw(String text) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeRaw", String.class);
        method.setAccessible(true);
        method.invoke(generator, text);
    }
}
