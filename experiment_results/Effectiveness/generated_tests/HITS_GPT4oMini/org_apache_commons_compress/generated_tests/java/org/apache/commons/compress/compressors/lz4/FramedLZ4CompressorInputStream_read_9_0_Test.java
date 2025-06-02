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

public class FramedLZ4CompressorInputStream_read_9_0_Test {

    private FramedLZ4CompressorInputStream compressorInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Set up a sample input stream for tests
        // Example input
        byte[] input = new byte[] { 0x4, 0x22, 0x4D, 0x18 };
        InputStream byteArrayInputStream = new ByteArrayInputStream(input);
        compressorInputStream = new FramedLZ4CompressorInputStream(byteArrayInputStream);
    }

    @Test
    public void testReadWithZeroLength() throws IOException {
        byte[] buffer = new byte[10];
        int result = compressorInputStream.read(buffer, 0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testReadReturnsNegativeOneWhenEndReached() throws IOException {
        byte[] buffer = new byte[10];
        // Read to the end
        compressorInputStream.read(buffer, 0, buffer.length);
        // Attempt to read again
        int result = compressorInputStream.read(buffer, 0, buffer.length);
        assertEquals(-1, result);
    }

    @Test
    public void testReadReturnsData() throws IOException {
        byte[] buffer = new byte[4];
        int result = compressorInputStream.read(buffer, 0, buffer.length);
        assertEquals(4, result);
        assertEquals(0x4, buffer[0]);
        assertEquals(0x22, buffer[1]);
        assertEquals(0x4D, buffer[2]);
        assertEquals(0x18, buffer[3]);
    }

    @Test
    public void testReadHandlesPartialBuffer() throws IOException {
        byte[] buffer = new byte[2];
        int result = compressorInputStream.read(buffer, 0, buffer.length);
        assertEquals(2, result);
        assertEquals(0x4, buffer[0]);
        assertEquals(0x22, buffer[1]);
    }

    @Test
    public void testReadThrowsIOExceptionWhenInputStreamIsClosed() throws IOException {
        compressorInputStream.close();
        byte[] buffer = new byte[10];
        assertThrows(IOException.class, () -> {
            compressorInputStream.read(buffer, 0, buffer.length);
        });
    }
}
