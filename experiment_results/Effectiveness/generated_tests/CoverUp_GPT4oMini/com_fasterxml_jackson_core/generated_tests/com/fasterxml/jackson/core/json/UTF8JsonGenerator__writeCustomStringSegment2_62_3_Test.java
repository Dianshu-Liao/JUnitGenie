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

public class UTF8JsonGenerator__writeCustomStringSegment2_62_3_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, outputStream, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteCustomStringSegment2_withNoEscapes() throws Exception {
        char[] input = "Hello".toCharArray();
        invokeWriteCustomStringSegment2(input, 0, input.length);
        assertArrayEquals("Hello".getBytes(), outputStream.toByteArray());
    }

    private void invokeWriteCustomStringSegment2(char[] cbuf, int offset, int end) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeCustomStringSegment2", char[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, (Object) cbuf, offset, end);
    }
}
