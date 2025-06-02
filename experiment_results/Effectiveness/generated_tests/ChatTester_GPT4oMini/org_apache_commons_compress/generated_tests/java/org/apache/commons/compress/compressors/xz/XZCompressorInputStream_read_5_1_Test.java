package org.apache.commons.compress.compressors.xz;

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
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

public class XZCompressorInputStream_read_5_1_Test {

    private InputStream mockInputStream;

    private XZCompressorInputStream xzCompressorInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        mockInputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3, 4, 5 });
        xzCompressorInputStream = new XZCompressorInputStream(mockInputStream);
    }

    @Test
    public void testReadReturnsZeroWhenLengthIsZero() throws IOException {
        byte[] buffer = new byte[10];
        int result = xzCompressorInputStream.read(buffer, 0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testReadReturnsBytes() throws IOException {
        byte[] buffer = new byte[10];
        int result = xzCompressorInputStream.read(buffer, 0, 5);
        assertEquals(5, result);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, buffer);
    }

    @Test
    public void testReadHandlesMemoryLimitException() throws IOException {
        InputStream faultyInputStream = mock(InputStream.class);
        xzCompressorInputStream = new XZCompressorInputStream(faultyInputStream);
        byte[] buffer = new byte[10];
        when(faultyInputStream.read(buffer, 0, 5)).thenThrow(new org.tukaani.xz.MemoryLimitException(100, 50));
        Exception exception = assertThrows(MemoryLimitException.class, () -> {
            xzCompressorInputStream.read(buffer, 0, 5);
        });
        assertTrue(exception.getMessage().contains("Memory needed: 100"));
    }

    @Test
    public void testReadHandlesPartialRead() throws IOException {
        byte[] buffer = new byte[10];
        int result = xzCompressorInputStream.read(buffer, 0, 3);
        assertEquals(3, result);
        assertArrayEquals(new byte[] { 1, 2, 3 }, new byte[] { buffer[0], buffer[1], buffer[2] });
    }

    @Test
    public void testReadHandlesEndOfStream() throws IOException {
        InputStream emptyInputStream = new ByteArrayInputStream(new byte[] {});
        xzCompressorInputStream = new XZCompressorInputStream(emptyInputStream);
        byte[] buffer = new byte[10];
        int result = xzCompressorInputStream.read(buffer, 0, 10);
        // End of stream should return -1
        assertEquals(-1, result);
    }
}
