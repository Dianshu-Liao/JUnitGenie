package org.apache.commons.compress.compressors.lz77support;

import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

class AbstractLZ77CompressorInputStream_readLiteral_9_4_Test {

    private AbstractLZ77CompressorInputStream compressorInputStream;

    @BeforeEach
    void setUp() {
        // Mock InputStream with a sample byte array
        byte[] inputData = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        compressorInputStream = new AbstractLZ77CompressorInputStream(inputStream, 5) {
        };
    }

    @Test
    void testReadLiteralWithAvailableBytes() throws Exception {
        byte[] output = new byte[5];
        int bytesRead = invokeReadLiteral(output, 0, 5);
        assertEquals(5, bytesRead);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, output);
    }

    @Test
    void testReadLiteralWithInsufficientBuffer() throws Exception {
        // Buffer larger than the input
        byte[] output = new byte[15];
        int bytesRead = invokeReadLiteral(output, 0, 15);
        assertEquals(10, bytesRead);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, Arrays.copyOf(output, bytesRead));
    }

    @Test
    void testReadLiteralThrowsIOException() throws Exception {
        // Create an InputStream that will simulate end of stream
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[] {});
        compressorInputStream = new AbstractLZ77CompressorInputStream(inputStream, 5) {
        };
        byte[] output = new byte[5];
        assertThrows(IOException.class, () -> invokeReadLiteral(output, 0, 5));
    }

    private int invokeReadLiteral(byte[] b, int off, int len) throws Exception {
        Method method = AbstractLZ77CompressorInputStream.class.getDeclaredMethod("readLiteral", byte[].class, int.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(compressorInputStream, b, off, len);
    }
}
