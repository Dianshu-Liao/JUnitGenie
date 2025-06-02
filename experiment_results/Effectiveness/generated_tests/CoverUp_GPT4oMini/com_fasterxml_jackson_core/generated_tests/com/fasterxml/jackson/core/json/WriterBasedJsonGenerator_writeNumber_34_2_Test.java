package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
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

public class WriterBasedJsonGenerator_writeNumber_34_2_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, Mockito.mock(ObjectCodec.class), stringWriter);
    }

    @Test
    public void testWriteNumber_PositiveShort() throws Exception {
        short value = 123;
        invokeWriteNumber(value);
        assertEquals("123", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_NegativeShort() throws Exception {
        short value = -123;
        invokeWriteNumber(value);
        assertEquals("-123", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_Zero() throws Exception {
        short value = 0;
        invokeWriteNumber(value);
        assertEquals("0", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_Overflow() throws Exception {
        short value = Short.MAX_VALUE;
        invokeWriteNumber(value);
        assertEquals("32767", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_FlushBuffer() throws Exception {
        // Simulate a scenario that requires buffer flushing
        generator = new WriterBasedJsonGenerator(ioContext, 0, Mockito.mock(ObjectCodec.class), new StringWriter());
        Method flushBufferMethod = WriterBasedJsonGenerator.class.getDeclaredMethod("_flushBuffer");
        flushBufferMethod.setAccessible(true);
        flushBufferMethod.invoke(generator);
        short value = 1;
        invokeWriteNumber(value);
        assertEquals("1", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_ThrowsIOException() throws Exception {
        // Mock the writer to throw IOException
        Writer mockWriter = Mockito.mock(Writer.class);
        Mockito.doThrow(new IOException("Test Exception")).when(mockWriter).write(Mockito.any(char[].class), Mockito.anyInt(), Mockito.anyInt());
        generator = new WriterBasedJsonGenerator(ioContext, 0, Mockito.mock(ObjectCodec.class), mockWriter);
        short value = 123;
        assertThrows(IOException.class, () -> invokeWriteNumber(value));
    }

    private void invokeWriteNumber(short value) throws Exception {
        Method writeNumberMethod = WriterBasedJsonGenerator.class.getDeclaredMethod("writeNumber", short.class);
        writeNumberMethod.setAccessible(true);
        writeNumberMethod.invoke(generator, value);
    }
}
