package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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

public class WriterBasedJsonGenerator_writeRawLong_31_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        // Assuming IOContext and ObjectCodec are properly mocked or instantiated
        IOContext ioContext = Mockito.mock(IOContext.class);
        ObjectCodec objectCodec = Mockito.mock(ObjectCodec.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, objectCodec, stringWriter, '"');
        // Initialize necessary fields for testing
        // Example buffer size
        generator._outputBuffer = new char[64];
        generator._outputTail = 0;
        generator._outputEnd = generator._outputBuffer.length;
    }

    @Test
    public void testWriteRawLong_FitsInBuffer() throws Exception {
        String text = "Hello, World!";
        invokeWriteRawLong(text);
        assertEquals("Hello, World!", stringWriter.toString());
    }

    @Test
    public void testWriteRawLong_ExceedsBuffer() throws Exception {
        String text = "This is a long string that exceeds the buffer size.";
        invokeWriteRawLong(text);
        assertEquals("This is a long string that exceeds the buffer size.", stringWriter.toString());
    }

    @Test
    public void testWriteRawLong_EmptyString() throws Exception {
        String text = "";
        invokeWriteRawLong(text);
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testWriteRawLong_NullString() {
        assertThrows(NullPointerException.class, () -> {
            invokeWriteRawLong(null);
        });
    }

    @Test
    public void testWriteRawLong_SingleCharacter() throws Exception {
        String text = "A";
        invokeWriteRawLong(text);
        assertEquals("A", stringWriter.toString());
    }

    @Test
    public void testWriteRawLong_BorderlineBufferSize() throws Exception {
        String text = new String(new char[64]).replace('\0', 'A');
        invokeWriteRawLong(text);
        assertEquals(text, stringWriter.toString());
    }

    @Test
    public void testWriteRawLong_MultipleFlushes() throws Exception {
        String text = "This string will be split into multiple flushes.";
        generator._outputEnd = 10;
        invokeWriteRawLong(text);
        assertEquals("This strin", stringWriter.toString());
    }

    private void invokeWriteRawLong(String text) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeRawLong", String.class);
        method.setAccessible(true);
        method.invoke(generator, text);
    }
}
