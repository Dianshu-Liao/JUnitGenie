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

public class WriterBasedJsonGenerator__writeQuotedInt_37_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer, '"');
    }

    @Test
    public void testWriteQuotedIntPositive() throws Exception {
        invokeWriteQuotedInt(123);
        assertEquals("\"123\"", writer.toString());
    }

    @Test
    public void testWriteQuotedIntNegative() throws Exception {
        invokeWriteQuotedInt(-456);
        assertEquals("\"-456\"", writer.toString());
    }

    @Test
    public void testWriteQuotedIntZero() throws Exception {
        invokeWriteQuotedInt(0);
        assertEquals("\"0\"", writer.toString());
    }

    @Test
    public void testWriteQuotedIntMinValue() throws Exception {
        invokeWriteQuotedInt(Integer.MIN_VALUE);
        assertEquals("\"-2147483648\"", writer.toString());
    }

    @Test
    public void testWriteQuotedIntMaxValue() throws Exception {
        invokeWriteQuotedInt(Integer.MAX_VALUE);
        assertEquals("\"2147483647\"", writer.toString());
    }

    private void invokeWriteQuotedInt(int value) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeQuotedInt", int.class);
        method.setAccessible(true);
        method.invoke(generator, value);
    }
}
