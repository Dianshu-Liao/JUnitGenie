package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class BZip2CompressorOutputStream_BZip2CompressorOutputStream_31_0_Test {

    @Test
    public void testConstructorWithValidOutputStream() throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        BZip2CompressorOutputStream compressorOutputStream = new BZip2CompressorOutputStream(outputStream);
        Assertions.assertNotNull(compressorOutputStream);
    }

    @Test
    public void testConstructorWithValidOutputStreamAndBlockSize() throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        // within valid range
        int blockSize = 5;
        BZip2CompressorOutputStream compressorOutputStream = new BZip2CompressorOutputStream(outputStream, blockSize);
        Assertions.assertNotNull(compressorOutputStream);
        Assertions.assertEquals(blockSize, compressorOutputStream.getBlockSize());
    }

    @Test
    public void testConstructorWithBlockSizeLessThanOne() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            OutputStream outputStream = new ByteArrayOutputStream();
            new BZip2CompressorOutputStream(outputStream, 0);
        });
    }

    @Test
    public void testConstructorWithBlockSizeGreaterThanNine() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            OutputStream outputStream = new ByteArrayOutputStream();
            new BZip2CompressorOutputStream(outputStream, 10);
        });
    }

    @Test
    public void testGetBlockSize() throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        // valid block size
        int blockSize = 3;
        BZip2CompressorOutputStream compressorOutputStream = new BZip2CompressorOutputStream(outputStream, blockSize);
        Assertions.assertEquals(blockSize, compressorOutputStream.getBlockSize());
    }
}
