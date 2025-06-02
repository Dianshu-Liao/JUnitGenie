package org.apache.commons.compress.compressors.snappy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;
import org.apache.commons.codec.digest.PureJavaCrc32C;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

public class FramedSnappyCompressorInputStream_read_5_0_Test {

    private FramedSnappyCompressorInputStream compressorInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Example input stream for testing
        // Example byte array
        byte[] inputData = new byte[] { 0x1, 0x2, 0x3, 0x4, 0x5 };
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputData);
        compressorInputStream = new FramedSnappyCompressorInputStream(byteArrayInputStream);
    }

    @Test
    public void testReadSingleByte() throws IOException {
        int firstByte = compressorInputStream.read();
        assertEquals(1, firstByte);
        int secondByte = compressorInputStream.read();
        assertEquals(2, secondByte);
    }

    @Test
    public void testReadReturnsMinusOneAtEnd() throws IOException {
        // Read all bytes
        // 1
        compressorInputStream.read();
        // 2
        compressorInputStream.read();
        // 3
        compressorInputStream.read();
        // 4
        compressorInputStream.read();
        // 5
        compressorInputStream.read();
        // Now it should return -1
        assertEquals(-1, compressorInputStream.read());
    }

    @Test
    public void testReadWithZeroLength() throws IOException {
        byte[] buffer = new byte[5];
        int result = compressorInputStream.read(buffer, 0, 0);
        // Should return 0 for zero length read
        assertEquals(0, result);
    }

    @Test
    public void testReadIntoBuffer() throws IOException {
        byte[] buffer = new byte[5];
        int bytesRead = compressorInputStream.read(buffer, 0, buffer.length);
        assertEquals(5, bytesRead);
        assertEquals(1, buffer[0]);
        assertEquals(2, buffer[1]);
        assertEquals(3, buffer[2]);
        assertEquals(4, buffer[3]);
        assertEquals(5, buffer[4]);
    }

    @Test
    public void testReadBeyondBufferLength() throws IOException {
        byte[] buffer = new byte[3];
        int bytesRead = compressorInputStream.read(buffer, 0, buffer.length);
        assertEquals(3, bytesRead);
        assertEquals(1, buffer[0]);
        assertEquals(2, buffer[1]);
        assertEquals(3, buffer[2]);
        // Read remaining bytes
        bytesRead = compressorInputStream.read(buffer, 0, buffer.length);
        // Only two bytes left
        assertEquals(2, bytesRead);
        assertEquals(4, buffer[0]);
        assertEquals(5, buffer[1]);
    }

    @Test
    public void testReadWithInvalidOffset() {
        byte[] buffer = new byte[5];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid offset
            compressorInputStream.read(buffer, -1, 5);
        });
    }

    @Test
    public void testReadWithInvalidLength() {
        byte[] buffer = new byte[5];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid length
            compressorInputStream.read(buffer, 0, -1);
        });
    }

    @Test
    public void testReadOnEmptyStream() throws IOException {
        // Create an empty InputStream
        ByteArrayInputStream emptyStream = new ByteArrayInputStream(new byte[0]);
        FramedSnappyCompressorInputStream emptyCompressorInputStream = new FramedSnappyCompressorInputStream(emptyStream);
        assertEquals(-1, emptyCompressorInputStream.read());
    }
}
