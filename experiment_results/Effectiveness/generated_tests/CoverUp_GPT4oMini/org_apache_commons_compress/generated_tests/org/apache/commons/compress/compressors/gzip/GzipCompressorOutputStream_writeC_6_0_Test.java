package org.apache.commons.compress.compressors.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

class GzipCompressorOutputStream_writeC_6_0_Test {

    private ByteArrayOutputStream outputStream;

    private GzipCompressorOutputStream gzipCompressorOutputStream;

    private GzipParameters parameters;

    @BeforeEach
    void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        parameters = new GzipParameters();
        gzipCompressorOutputStream = new GzipCompressorOutputStream(outputStream, parameters);
    }

    @Test
    void testWriteC_NullValue() throws Exception {
        invokeWriteCMethod(null, StandardCharsets.UTF_8);
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    void testWriteC_EmptyString() throws Exception {
        invokeWriteCMethod("", StandardCharsets.UTF_8);
        assertArrayEquals(new byte[] { 0 }, outputStream.toByteArray());
    }

    @Test
    void testWriteC_ValidString() throws Exception {
        String testString = "Hello";
        invokeWriteCMethod(testString, StandardCharsets.UTF_8);
        byte[] expected = "Hello".getBytes(StandardCharsets.UTF_8);
        byte[] result = outputStream.toByteArray();
        assertArrayEquals(concatArrays(expected, new byte[] { 0 }), result);
    }

    @Test
    void testWriteC_WithDifferentCharset() throws Exception {
        // "Hello" in Japanese
        String testString = "こんにちは";
        invokeWriteCMethod(testString, Charset.forName("UTF-8"));
        byte[] expected = testString.getBytes(Charset.forName("UTF-8"));
        byte[] result = outputStream.toByteArray();
        assertArrayEquals(concatArrays(expected, new byte[] { 0 }), result);
    }

    private void invokeWriteCMethod(String value, Charset charset) throws Exception {
        Method method = GzipCompressorOutputStream.class.getDeclaredMethod("writeC", String.class, Charset.class);
        method.setAccessible(true);
        method.invoke(gzipCompressorOutputStream, value, charset);
    }

    private byte[] concatArrays(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
}
