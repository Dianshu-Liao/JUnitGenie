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

public class WriterBasedJsonGenerator__writeBinary_67_1_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
        base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    public void testWriteBinaryWithFullChunks() throws Exception {
        byte[] input = { (byte) 0xFF, (byte) 0xEE, (byte) 0xDD };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        byte[] readBuffer = new byte[3];
        invokeWriteBinary(generator, base64Variant, inputStream, readBuffer);
        // Example expected output based on encoding
        String expectedOutput = "/////w==\n";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void testWriteBinaryWithPartialChunks() throws Exception {
        byte[] input = { (byte) 0xFF, (byte) 0xEE };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        byte[] readBuffer = new byte[3];
        invokeWriteBinary(generator, base64Variant, inputStream, readBuffer);
        // Example expected output based on encoding
        String expectedOutput = "/////w==";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void testWriteBinaryWithNoData() throws Exception {
        byte[] input = {};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        byte[] readBuffer = new byte[3];
        int bytesWritten = invokeWriteBinary(generator, base64Variant, inputStream, readBuffer);
        assertEquals(0, bytesWritten);
        assertEquals("", writer.toString());
    }

    private int invokeWriteBinary(WriterBasedJsonGenerator generator, Base64Variant b64variant, ByteArrayInputStream data, byte[] readBuffer) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeBinary", Base64Variant.class, InputStream.class, byte[].class);
        method.setAccessible(true);
        return (int) method.invoke(generator, b64variant, data, readBuffer);
    }
}
