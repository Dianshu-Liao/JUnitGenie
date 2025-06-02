package org.apache.commons.compress.compressors.lz77support;

import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.input.BoundedInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

class AbstractLZ77CompressorInputStream_readLiteral_9_0_Test {

    private AbstractLZ77CompressorInputStream compressorInputStream;

    private ByteArrayInputStream mockInputStream;

    @BeforeEach
    void setUp() {
        mockInputStream = Mockito.mock(ByteArrayInputStream.class);
        compressorInputStream = new AbstractLZ77CompressorInputStream(mockInputStream, 10) {

            @Override
            public long getCompressedCount() {
                return 0;
            }

            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public int available() {
                return 5;
            }

            protected void tryToReadLiteral(int bytesNeeded) throws IOException {
                // Mock implementation to simulate reading bytes
                when(mockInputStream.read(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt())).thenReturn(bytesNeeded);
            }

            protected int readFromBuffer(byte[] b, int off, int len) {
                System.arraycopy(new byte[] { 1, 2, 3, 4, 5 }, 0, b, off, len);
                return len;
            }
        };
    }

    @Test
    void testReadLiteral_withAvailableBytes() throws IOException {
        byte[] input = { 1, 2, 3, 4, 5 };
        when(mockInputStream.read(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt())).thenAnswer(invocation -> {
            byte[] buffer = invocation.getArgument(0);
            int offset = invocation.getArgument(1);
            int length = Math.min(input.length, invocation.getArgument(2));
            System.arraycopy(input, 0, buffer, offset, length);
            return length;
        });
        byte[] output = new byte[5];
        int bytesRead = invokeReadLiteral(output, 0, 5);
        assertEquals(5, bytesRead);
        assertEquals(1, output[0]);
        assertEquals(2, output[1]);
        assertEquals(3, output[2]);
        assertEquals(4, output[3]);
        assertEquals(5, output[4]);
    }

    @Test
    void testReadLiteral_withInsufficientBytes() throws IOException {
        byte[] output = new byte[10];
        when(mockInputStream.read(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt())).thenReturn(-1);
        assertThrows(IOException.class, () -> invokeReadLiteral(output, 0, 10));
    }

    @Test
    void testReadLiteral_withExactAvailableBytes() throws IOException {
        byte[] input = { 1, 2, 3 };
        when(mockInputStream.read(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt())).thenAnswer(invocation -> {
            byte[] buffer = invocation.getArgument(0);
            int offset = invocation.getArgument(1);
            System.arraycopy(input, 0, buffer, offset, input.length);
            return input.length;
        });
        byte[] output = new byte[3];
        int bytesRead = invokeReadLiteral(output, 0, 3);
        assertEquals(3, bytesRead);
        assertEquals(1, output[0]);
        assertEquals(2, output[1]);
        assertEquals(3, output[2]);
    }

    private int invokeReadLiteral(byte[] b, int off, int len) throws IOException {
        try {
            java.lang.reflect.Method method = AbstractLZ77CompressorInputStream.class.getDeclaredMethod("readLiteral", byte[].class, int.class, int.class);
            method.setAccessible(true);
            return (int) method.invoke(compressorInputStream, b, off, len);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
