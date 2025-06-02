package org.apache.commons.compress.compressors.lz4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.zip.CheckedInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

class FramedLZ4CompressorInputStream_read_8_0_Test {

    private FramedLZ4CompressorInputStream compressorInputStream;

    @BeforeEach
    void setUp() throws IOException {
        // Initialize with an empty input stream for the first test
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        compressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
    }

    @Test
    void testReadReturnsMinusOneForEmptyStream() throws IOException {
        assertEquals(-1, compressorInputStream.read());
    }

    @Test
    void testReadSingleByte() throws IOException {
        byte[] inputData = new byte[] { 1, 2, 3, 4, 5 };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        compressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
        assertEquals(1, compressorInputStream.read());
        assertEquals(2, compressorInputStream.read());
        assertEquals(3, compressorInputStream.read());
        assertEquals(4, compressorInputStream.read());
        assertEquals(5, compressorInputStream.read());
        // End of stream
        assertEquals(-1, compressorInputStream.read());
    }

    @Test
    void testReadMultipleBytes() throws IOException {
        byte[] inputData = new byte[] { 10, 20, 30, 40, 50 };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        compressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
        byte[] buffer = new byte[5];
        int bytesRead = compressorInputStream.read(buffer, 0, buffer.length);
        assertEquals(5, bytesRead);
        assertArrayEquals(new byte[] { 10, 20, 30, 40, 50 }, buffer);
    }

    @Test
    void testReadWithOffsetAndLength() throws IOException {
        byte[] inputData = new byte[] { 100, 101, 102, 103, 104 };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        compressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
        byte[] buffer = new byte[10];
        int bytesRead = compressorInputStream.read(buffer, 1, 4);
        assertEquals(4, bytesRead);
        // Default value
        assertEquals(0, buffer[0]);
        assertArrayEquals(new byte[] { 0, 100, 101, 102, 103, 0, 0, 0, 0, 0 }, buffer);
    }

    @Test
    void testReadReturnsMinusOneAfterEndOfStream() throws IOException {
        byte[] inputData = new byte[] { 1, 2, 3 };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        compressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
        // Read first byte
        compressorInputStream.read();
        // Read second byte
        compressorInputStream.read();
        // Read third byte
        compressorInputStream.read();
        // End of stream
        assertEquals(-1, compressorInputStream.read());
    }
}
