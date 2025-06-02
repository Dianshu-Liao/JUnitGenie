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

public class WriterBasedJsonGenerator_writeRawLong_31_1_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);
    }

    @Test
    public void testWriteRawLong_WithShortText() throws Exception {
        invokeWriteRawLong("Hello");
        assertEquals("Hello", stringWriter.toString());
    }

    @Test
    public void testWriteRawLong_WithExactBufferSize() throws Exception {
        // Assuming buffer size can accommodate this
        String longText = "12345678901234567890";
        invokeWriteRawLong(longText);
        assertEquals(longText, stringWriter.toString());
    }

    @Test
    public void testWriteRawLong_WithLongText() throws Exception {
        String longText = "This is a long text that exceeds the buffer size and needs to be flushed multiple times.";
        invokeWriteRawLong(longText);
        assertEquals(longText, stringWriter.toString());
    }

    @Test
    public void testWriteRawLong_WithEmptyText() throws Exception {
        invokeWriteRawLong("");
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testWriteRawLong_WithNullText() throws Exception {
        invokeWriteRawLong(null);
        assertEquals("", stringWriter.toString());
    }

    private void invokeWriteRawLong(String text) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeRawLong", String.class);
        method.setAccessible(true);
        method.invoke(generator, text);
    }
}
