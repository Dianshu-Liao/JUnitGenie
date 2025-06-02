package org.apache.commons.compress.compressors.lz77support;

import org.apache.commons.io.input.BoundedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractLZ77CompressorInputStream_readLiteral_9_2_Test {

    private AbstractLZ77CompressorInputStream compressorInputStream;

    @BeforeEach
    void setUp() {
        // Create a mock InputStream with some data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3, 4, 5 });
        compressorInputStream = new TestLZ77CompressorInputStream(inputStream, 10);
    }

    @Test
    void testReadLiteralWhenAvailableBytesAreLessThanRequested() throws Exception {
        byte[] buffer = new byte[10];
        int bytesRead = invokeReadLiteral(buffer, 0, 10);
        // Should read all available bytes
        assertEquals(5, bytesRead);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 }, buffer);
    }

    @Test
    void testReadLiteralWhenExactAvailableBytesAreRequested() throws Exception {
        byte[] buffer = new byte[5];
        int bytesRead = invokeReadLiteral(buffer, 0, 5);
        // Should read all available bytes
        assertEquals(5, bytesRead);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, buffer);
    }

    @Test
    void testReadLiteralWhenMoreBytesAreRequestedThanAvailable() throws Exception {
        byte[] buffer = new byte[8];
        // Read first 5 bytes
        invokeReadLiteral(buffer, 0, 5);
        // Request 3 more
        int bytesRead = invokeReadLiteral(buffer, 5, 3);
        // No more bytes should be available
        assertEquals(0, bytesRead);
        // Buffer should remain unchanged
        assertArrayEquals(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 }, buffer);
    }

    @Test
    void testReadLiteralHandlesIOException() throws Exception {
        // Simulate an IOException by creating a stream that throws an exception
        InputStream inputStream = new InputStream() {

            private final byte[] data = { 1, 2, 3, 4, 5 };

            private int index = 0;

            @Override
            public int read() throws IOException {
                if (index < data.length) {
                    return data[index++];
                }
                throw new IOException("Simulated IOException");
            }

            @Override
            public int read(byte[] b, int off, int len) throws IOException {
                if (index < data.length) {
                    int toRead = Math.min(len, data.length - index);
                    System.arraycopy(data, index, b, off, toRead);
                    index += toRead;
                    return toRead;
                }
                throw new IOException("Simulated IOException");
            }
        };
        compressorInputStream = new TestLZ77CompressorInputStream(inputStream, 10);
        byte[] buffer = new byte[5];
        assertThrows(IOException.class, () -> {
            invokeReadLiteral(buffer, 0, 5);
        });
    }

    private int invokeReadLiteral(byte[] buffer, int off, int len) throws Exception {
        Method method = AbstractLZ77CompressorInputStream.class.getDeclaredMethod("readLiteral", byte[].class, int.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(compressorInputStream, buffer, off, len);
    }

    private static class TestLZ77CompressorInputStream extends AbstractLZ77CompressorInputStream {

        public TestLZ77CompressorInputStream(InputStream is, int windowSize) {
            super(is, windowSize);
        }

        @Override
        public long getCompressedCount() {
            return super.getCompressedCount();
        }

        @Override
        public int getSize() {
            return super.getSize();
        }
    }
}
