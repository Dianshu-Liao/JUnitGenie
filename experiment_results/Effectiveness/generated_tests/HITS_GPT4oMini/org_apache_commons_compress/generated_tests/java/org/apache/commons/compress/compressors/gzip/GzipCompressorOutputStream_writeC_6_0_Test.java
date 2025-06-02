package org.apache.commons.compress.compressors.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class GzipCompressorOutputStream_writeC_6_0_Test {

    private ByteArrayOutputStream outputStream;

    private GzipCompressorOutputStream gzipCompressorOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        gzipCompressorOutputStream = new GzipCompressorOutputStream(outputStream);
    }

    private void invokeWriteC(String value, Charset charset) throws Exception {
        Method method = GzipCompressorOutputStream.class.getDeclaredMethod("writeC", String.class, Charset.class);
        method.setAccessible(true);
        method.invoke(gzipCompressorOutputStream, value, charset);
    }

    private long getCRCValue() throws Exception {
        Field crcField = GzipCompressorOutputStream.class.getDeclaredField("crc");
        crcField.setAccessible(true);
        CRC32 crc = (CRC32) crcField.get(gzipCompressorOutputStream);
        return crc.getValue();
    }

    @Test
    public void testWriteC_NullValue() throws Exception {
        invokeWriteC(null, StandardCharsets.UTF_8);
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteC_EmptyString() throws Exception {
        invokeWriteC("", StandardCharsets.UTF_8);
        assertArrayEquals(new byte[] { 0 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteC_ValidString() throws Exception {
        String value = "Hello";
        Charset charset = StandardCharsets.UTF_8;
        byte[] expectedOutput = "Hello\0".getBytes(charset);
        invokeWriteC(value, charset);
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteC_ValidStringWithDifferentCharset() throws Exception {
        // "Hello" in Russian
        String value = "Привет";
        Charset charset = StandardCharsets.UTF_8;
        byte[] expectedOutput = "Привет\0".getBytes(charset);
        invokeWriteC(value, charset);
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteC_UpdateCRC() throws Exception {
        String value = "Test";
        Charset charset = StandardCharsets.UTF_8;
        invokeWriteC(value, charset);
        CRC32 crc = new CRC32();
        crc.update(value.getBytes(charset));
        crc.update(0);
        assertEquals(crc.getValue(), getCRCValue());
    }

    @Test
    public void testWriteC_MultipleWrites() throws Exception {
        String value1 = "First";
        String value2 = "Second";
        Charset charset = StandardCharsets.UTF_8;
        invokeWriteC(value1, charset);
        invokeWriteC(value2, charset);
        byte[] expectedOutput = "First\0Second\0".getBytes(charset);
    }
}
