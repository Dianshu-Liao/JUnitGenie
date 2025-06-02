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

class WriterBasedJsonGenerator__writeBinary_65_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        ioContext = new IOContext(null, writer, true);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
    }

    @Test
    void testWriteBinaryFullChunks() throws Exception {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD, (byte) 0xFC };
        invokeWriteBinary(generator, base64Variant, input, 0, input.length);
        String expectedOutput = "/////w==\\n";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    void testWriteBinaryPartialChunk() throws Exception {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = { (byte) 0xFF, (byte) 0xFE };
        invokeWriteBinary(generator, base64Variant, input, 0, input.length);
        String expectedOutput = "//+w==";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    void testWriteBinaryNoInput() throws Exception {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = {};
        invokeWriteBinary(generator, base64Variant, input, 0, input.length);
        assertEquals("", writer.toString());
    }

    private void invokeWriteBinary(WriterBasedJsonGenerator generator, Base64Variant b64variant, byte[] input, int inputPtr, int inputEnd) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeBinary", Base64Variant.class, byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, b64variant, input, inputPtr, inputEnd);
    }
}
