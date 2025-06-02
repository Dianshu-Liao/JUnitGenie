package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class BZip2CompressorOutputStream_BZip2CompressorOutputStream_32_0_Test {

    @Test
    public void testConstructorWithValidBlockSize() throws IOException {
        // Test with a valid block size
        int blockSize = 5;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BZip2CompressorOutputStream bzip2OutputStream = new BZip2CompressorOutputStream(outputStream, blockSize);
        assertEquals(blockSize, bzip2OutputStream.getBlockSize());
    }

    @Test
    public void testConstructorWithMinimumBlockSize() throws IOException {
        // Test with minimum block size
        int blockSize = BZip2CompressorOutputStream.MIN_BLOCKSIZE;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BZip2CompressorOutputStream bzip2OutputStream = new BZip2CompressorOutputStream(outputStream, blockSize);
        assertEquals(blockSize, bzip2OutputStream.getBlockSize());
    }

    @Test
    public void testConstructorWithMaximumBlockSize() throws IOException {
        // Test with maximum block size
        int blockSize = BZip2CompressorOutputStream.MAX_BLOCKSIZE;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BZip2CompressorOutputStream bzip2OutputStream = new BZip2CompressorOutputStream(outputStream, blockSize);
        assertEquals(blockSize, bzip2OutputStream.getBlockSize());
    }

    @Test
    public void testConstructorWithBlockSizeLessThanMinimum() {
        // Test with block size less than minimum
        int blockSize = 0;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BZip2CompressorOutputStream(outputStream, blockSize);
        });
        assertEquals("blockSize(0) < 1", exception.getMessage());
    }

    @Test
    public void testConstructorWithBlockSizeGreaterThanMaximum() {
        // Test with block size greater than maximum
        int blockSize = 10;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BZip2CompressorOutputStream(outputStream, blockSize);
        });
        assertEquals("blockSize(10) > 9", exception.getMessage());
    }
}
