package org.apache.commons.compress.compressors.xz;

import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.MemoryLimitException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class XZCompressorInputStream_read_5_1_Test {

    private XZCompressorInputStream xzCompressorInputStream;

    @BeforeEach
    void setUp() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3, 4, 5 });
        xzCompressorInputStream = new XZCompressorInputStream(inputStream);
    }

    @Test
    void testReadReturnsZeroWhenLengthIsZero() throws IOException {
        byte[] buffer = new byte[10];
        int result = xzCompressorInputStream.read(buffer, 0, 0);
        assertEquals(0, result);
    }

    @Test
    void testReadReturnsCorrectNumberOfBytes() throws IOException {
        byte[] buffer = new byte[10];
        int result = xzCompressorInputStream.read(buffer, 0, 5);
        assertEquals(5, result);
        assertEquals(1, buffer[0]);
        assertEquals(2, buffer[1]);
        assertEquals(3, buffer[2]);
        assertEquals(4, buffer[3]);
        assertEquals(5, buffer[4]);
    }

    @Test
    void testReadThrowsMemoryLimitException() throws IOException {
        InputStream mockInputStream = Mockito.mock(InputStream.class);
        Mockito.when(mockInputStream.read(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt())).thenThrow(new org.tukaani.xz.MemoryLimitException(1024, 2048));
        xzCompressorInputStream = new XZCompressorInputStream(mockInputStream);
        MemoryLimitException thrown = assertThrows(MemoryLimitException.class, () -> xzCompressorInputStream.read(new byte[10], 0, 5));
    }
}
