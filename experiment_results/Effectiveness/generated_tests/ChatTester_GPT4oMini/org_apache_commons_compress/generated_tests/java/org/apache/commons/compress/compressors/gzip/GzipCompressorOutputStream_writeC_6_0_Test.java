package org.apache.commons.compress.compressors.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class GzipCompressorOutputStream_writeC_6_0_Test {

    private GzipCompressorOutputStream gzipCompressorOutputStream;

    private ByteArrayOutputStream outputStream;

    private static final Charset CHARSET = Charset.forName("UTF-8");

    @BeforeEach
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        gzipCompressorOutputStream = new GzipCompressorOutputStream(outputStream);
    }

    @Test
    public void testWriteC_NullValue() throws Exception {
        invokeWriteC(null, CHARSET);
        assertEquals(0, outputStream.size());
    }

    @Test
    public void testWriteC_EmptyValue() throws Exception {
        invokeWriteC("", CHARSET);
        assertEquals(1, outputStream.size());
        assertEquals(0, outputStream.toByteArray()[0]);
    }

    @Test
    public void testWriteC_ValidValue() throws Exception {
        String value = "Hello";
        invokeWriteC(value, CHARSET);
        byte[] expectedBytes = "Hello".getBytes(CHARSET);
        byte[] outputBytes = outputStream.toByteArray();
        assertArrayEquals(expectedBytes, new byte[] { outputBytes[0], outputBytes[1], outputBytes[2], outputBytes[3], outputBytes[4] });
        assertEquals(0, outputBytes[5]);
    }

    @Test
    public void testWriteC_ValidValueWithDifferentCharset() throws Exception {
        // "Hello" in Japanese
        String value = "こんにちは";
        invokeWriteC(value, Charset.forName("UTF-8"));
        byte[] expectedBytes = value.getBytes(Charset.forName("UTF-8"));
        byte[] outputBytes = outputStream.toByteArray();
        assertArrayEquals(expectedBytes, new byte[] { outputBytes[0], outputBytes[1], outputBytes[2], outputBytes[3], outputBytes[4], outputBytes[5], outputBytes[6] });
        assertEquals(0, outputBytes[expectedBytes.length]);
    }

    private void invokeWriteC(String value, Charset charset) throws Exception {
        Method method = GzipCompressorOutputStream.class.getDeclaredMethod("writeC", String.class, Charset.class);
        method.setAccessible(true);
        method.invoke(gzipCompressorOutputStream, value, charset);
    }
}
