package org.apache.commons.compress.compressors.lzma;

import org.apache.commons.compress.compressors.CompressorInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;
import org.tukaani.xz.LZMAInputStream;

public class LZMACompressorInputStream_read_4_2_Test {

    @Test
    public void testReadSingleByte() throws IOException {
        byte[] inputData = { 1, 2, 3, 4, 5 };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        LZMACompressorInputStream lzmaInputStream = new LZMACompressorInputStream(inputStream);
        assertEquals(1, lzmaInputStream.read());
        assertEquals(2, lzmaInputStream.read());
        assertEquals(3, lzmaInputStream.read());
        assertEquals(4, lzmaInputStream.read());
        assertEquals(5, lzmaInputStream.read());
        assertEquals(-1, lzmaInputStream.read());
    }

    @Test
    public void testReadMultipleBytes() throws IOException {
        byte[] inputData = { 10, 20, 30, 40, 50 };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        LZMACompressorInputStream lzmaInputStream = new LZMACompressorInputStream(inputStream);
        byte[] buffer = new byte[5];
        int bytesRead = lzmaInputStream.read(buffer);
        assertEquals(5, bytesRead);
        assertEquals(10, buffer[0]);
        assertEquals(20, buffer[1]);
        assertEquals(30, buffer[2]);
        assertEquals(40, buffer[3]);
        assertEquals(50, buffer[4]);
    }

    @Test
    public void testReadReturnsNegativeOneAtEnd() throws IOException {
        byte[] inputData = { 100 };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        LZMACompressorInputStream lzmaInputStream = new LZMACompressorInputStream(inputStream);
        // Read the first byte
        lzmaInputStream.read();
        // Should return -1 on the second read
        assertEquals(-1, lzmaInputStream.read());
    }

    @Test
    public void testGetBytesRead() throws IOException {
        byte[] inputData = { 1, 2, 3, 4, 5 };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        LZMACompressorInputStream lzmaInputStream = new LZMACompressorInputStream(inputStream);
        // Read one byte
        lzmaInputStream.read();
        // Should reflect the bytes read
        assertEquals(1, lzmaInputStream.getBytesRead());
    }
}
