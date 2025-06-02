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

public class WriterBasedJsonGenerator_writeString_19_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter, '"');
    }

    @Test
    public void testWriteString_NullInput() throws Exception {
        invokeWriteString(null);
        assertEquals("null", stringWriter.toString());
    }

    @Test
    public void testWriteString_EmptyString() throws Exception {
        invokeWriteString("");
        assertEquals("\"\"", stringWriter.toString());
    }

    @Test
    public void testWriteString_SimpleString() throws Exception {
        invokeWriteString("Hello");
        assertEquals("\"Hello\"", stringWriter.toString());
    }

    @Test
    public void testWriteString_LongString() throws Exception {
        String longString = "This is a long string that exceeds the buffer size.";
        invokeWriteString(longString);
        assertEquals("\"This is a long string that exceeds the buffer size.\"", stringWriter.toString());
    }

    private void invokeWriteString(String text) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeString", String.class);
        method.setAccessible(true);
        method.invoke(generator, text);
    }
}
