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

public class UTF8JsonGenerator_writeStartArray_5_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = mock(IOContext.class);
        StreamWriteConstraints constraints = mock(StreamWriteConstraints.class);
        when(constraints.getMaxNestingDepth()).thenReturn(1000);
        when(ioContext.streamWriteConstraints()).thenReturn(constraints);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    private void setWriteContext(JsonWriteContext context) throws Exception {
        Field writeContextField = UTF8JsonGenerator.class.getDeclaredField("_writeContext");
        writeContextField.setAccessible(true);
        writeContextField.set(generator, context);
    }

    @Test
    public void testWriteStartArray() throws IOException, Exception {
        JsonWriteContext context = mock(JsonWriteContext.class);
        when(context.getNestingDepth()).thenReturn(0);
        setWriteContext(context);
        generator.writeStartArray();
        assertEquals(1, generator.getOutputBuffered());
        assertEquals((byte) '[', outputStream.toByteArray()[0]);
    }

    @Test
    public void testWriteStartArrayWithNesting() throws IOException, Exception {
        JsonWriteContext parentContext = mock(JsonWriteContext.class);
        when(parentContext.getNestingDepth()).thenReturn(1);
        when(parentContext.createChildArrayContext()).thenReturn(mock(JsonWriteContext.class));
        setWriteContext(parentContext.createChildArrayContext());
        generator.writeStartArray();
        assertEquals(1, generator.getOutputBuffered());
        assertEquals((byte) '[', outputStream.toByteArray()[0]);
    }

    @Test
    public void testWriteStartArrayFlushesBuffer() throws IOException, Exception {
        generator._outputTail = 512;
        generator._outputBuffer = new byte[512];
        JsonWriteContext context = mock(JsonWriteContext.class);
        when(context.getNestingDepth()).thenReturn(0);
        setWriteContext(context);
        generator.writeStartArray();
        assertEquals(1, generator.getOutputBuffered());
        assertEquals((byte) '[', outputStream.toByteArray()[0]);
    }
}
