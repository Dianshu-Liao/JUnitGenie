package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

class // Additional tests can be added here to cover more edge cases or scenarios
BZip2CompressorOutputStream_BZip2CompressorOutputStream_32_0_Test {

    private OutputStream mockOutputStream;

    @BeforeEach
    void setUp() {
        mockOutputStream = mock(OutputStream.class);
    }

    @Test
    void testConstructorWithValidBlockSize() throws IOException {
        BZip2CompressorOutputStream compressor = new BZip2CompressorOutputStream(mockOutputStream, 5);
        assertEquals(5, compressor.getBlockSize());
    }

    @Test
    void testConstructorWithMinimumBlockSize() throws IOException {
        BZip2CompressorOutputStream compressor = new BZip2CompressorOutputStream(mockOutputStream, 1);
        assertEquals(1, compressor.getBlockSize());
    }

    @Test
    void testConstructorWithMaximumBlockSize() throws IOException {
        BZip2CompressorOutputStream compressor = new BZip2CompressorOutputStream(mockOutputStream, 9);
        assertEquals(9, compressor.getBlockSize());
    }

    @Test
    void testConstructorWithBlockSizeLessThanMinimum() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new BZip2CompressorOutputStream(mockOutputStream, 0);
        });
        assertEquals("blockSize(0) < 1", thrown.getMessage());
    }

    @Test
    void testConstructorWithBlockSizeGreaterThanMaximum() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new BZip2CompressorOutputStream(mockOutputStream, 10);
        });
        assertEquals("blockSize(10) > 9", thrown.getMessage());
    }

    @Test
    void testConstructorWithNegativeBlockSize() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new BZip2CompressorOutputStream(mockOutputStream, -1);
        });
        assertEquals("blockSize(-1) < 1", thrown.getMessage());
    }
}
