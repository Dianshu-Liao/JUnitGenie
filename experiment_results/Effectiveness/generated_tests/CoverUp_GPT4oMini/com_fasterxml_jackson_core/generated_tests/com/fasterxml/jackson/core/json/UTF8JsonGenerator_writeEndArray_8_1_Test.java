package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
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
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeEndArray_8_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    private JsonWriteContext writeContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = Mockito.mock(IOContext.class);
        writeContext = Mockito.mock(JsonWriteContext.class);
        Mockito.when(writeContext.inArray()).thenReturn(true);
        generator = new UTF8JsonGenerator(ioContext, 0, Mockito.mock(ObjectCodec.class), outputStream, '"');
        setField(generator, "_writeContext", writeContext);
    }

    @Test
    public void testWriteEndArray() throws IOException {
        generator.writeEndArray();
        assertEquals("]", outputStream.toString());
    }

    @Test
    public void testWriteEndArrayWithPrettyPrinter() throws IOException {
        // Mocking the pretty printer behavior
        PrettyPrinter prettyPrinter = Mockito.mock(PrettyPrinter.class);
        setField(generator, "_cfgPrettyPrinter", prettyPrinter);
        generator.writeEndArray();
        Mockito.verify(prettyPrinter).writeEndArray(generator, 0);
    }

    @Test
    public void testWriteEndArrayThrowsExceptionWhenNotInArray() {
        Mockito.when(writeContext.inArray()).thenReturn(false);
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeEndArray();
        });
        assertTrue(exception.getMessage().contains("Current context not Array"));
    }

    @Test
    public void testWriteEndArrayFlushesBufferWhenTailExceedsEnd() throws IOException {
        // Simulate full buffer
        setField(generator, "_outputTail", generator._outputEnd);
        generator.writeEndArray();
        Mockito.verify(generator, Mockito.times(1))._flushBuffer();
    }

    @Test
    public void testWriteEndArrayDoesNotFlushBufferWhenTailDoesNotExceedEnd() throws IOException {
        // Simulate available space
        setField(generator, "_outputTail", 0);
        generator.writeEndArray();
        Mockito.verify(generator, Mockito.never())._flushBuffer();
    }

    private void setField(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
