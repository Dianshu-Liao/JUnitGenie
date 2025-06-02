package org.apache.commons.compress.compressors.lz77support;

import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

public class AbstractLZ77CompressorInputStream_readLiteral_9_0_Test {

    private TestLZ77CompressorInputStream compressorInputStream;

    @BeforeEach
    public void setUp() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3, 4, 5 });
        compressorInputStream = new TestLZ77CompressorInputStream(inputStream, 5);
    }

    @Test
    public void testReadLiteral_WithAvailableBytes() throws IOException {
        byte[] output = new byte[3];
        int bytesRead = compressorInputStream.readLiteral(output, 0, 3);
        assertEquals(3, bytesRead);
        assertArrayEquals(new byte[] { 1, 2, 3 }, output);
    }

    @Test
    public void testReadLiteral_WithNotEnoughAvailableBytes() throws IOException {
        byte[] output = new byte[5];
        int bytesRead = compressorInputStream.readLiteral(output, 0, 5);
        assertEquals(5, bytesRead);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, output);
    }

    @Test
    public void testReadLiteral_WithExactBufferSize() throws IOException {
        byte[] output = new byte[5];
        int bytesRead = compressorInputStream.readLiteral(output, 0, 5);
        assertEquals(5, bytesRead);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, output);
    }

    @Test
    public void testReadLiteral_WithInsufficientBytesRemaining() throws IOException {
        byte[] output = new byte[10];
        assertThrows(IOException.class, () -> {
            compressorInputStream.readLiteral(output, 0, 10);
        });
    }

    @Test
    public void testReadLiteral_WithZeroLength() throws IOException {
        byte[] output = new byte[0];
        int bytesRead = compressorInputStream.readLiteral(output, 0, 0);
        assertEquals(0, bytesRead);
    }

    @Test
    public void testReadLiteral_WithNegativeLength() {
        byte[] output = new byte[5];
        assertThrows(IllegalArgumentException.class, () -> {
            compressorInputStream.readLiteral(output, 0, -1);
        });
    }

    private static class TestLZ77CompressorInputStream extends AbstractLZ77CompressorInputStream {

        public TestLZ77CompressorInputStream(ByteArrayInputStream is, int windowSize) {
            super(is, windowSize);
        }

        @Override
        public long getCompressedCount() {
            // Stub implementation for testing
            return 0;
        }
    }
}
