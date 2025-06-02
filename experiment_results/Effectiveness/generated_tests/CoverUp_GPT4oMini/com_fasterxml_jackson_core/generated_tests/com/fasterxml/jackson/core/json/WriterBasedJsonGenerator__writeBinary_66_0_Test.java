package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
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

public class WriterBasedJsonGenerator__writeBinary_66_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        ioContext = new IOContext(null, null, null, null, null, true);
        base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
    }

    @Test
    public void testWriteBinaryFullTriplet() throws Exception {
        byte[] input = new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        invokeWriteBinary(inputStream, 3);
        // Base64 encoding of FF FE FD
        String expected = "/////w==\n";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void testWriteBinaryPartialTriplet() throws Exception {
        byte[] input = new byte[] { (byte) 0xFF, (byte) 0xFE };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        invokeWriteBinary(inputStream, 2);
        // Base64 encoding of FF FE
        String expected = "/////w==";
        assertEquals(expected, writer.toString());
    }

    @Test
    public void testWriteBinarySingleByte() throws Exception {
        byte[] input = new byte[] { (byte) 0xFF };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        invokeWriteBinary(inputStream, 1);
        // Base64 encoding of FF
        String expected = "/////w==";
        assertEquals(expected, writer.toString());
    }

    private void invokeWriteBinary(InputStream data, int bytesLeft) throws Exception {
        java.lang.reflect.Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeBinary", Base64Variant.class, InputStream.class, byte[].class, int.class);
        method.setAccessible(true);
        byte[] readBuffer = new byte[3];
        method.invoke(generator, base64Variant, data, readBuffer, bytesLeft);
    }
}
