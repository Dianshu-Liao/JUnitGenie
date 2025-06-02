package org.apache.commons.compress.compressors.xz;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

class XZCompressorInputStream_read_4_1_Test {

    private XZCompressorInputStream xzCompressorInputStream;

    @BeforeEach
    void setUp() throws IOException {
        byte[] inputData = { 0x01, 0x02, 0x03, 0x04, -1 };
        InputStream byteArrayInputStream = new ByteArrayInputStream(inputData);
        xzCompressorInputStream = new XZCompressorInputStream(byteArrayInputStream);
    }

    @Test
    void testReadReturnsNextByte() throws IOException {
        int firstByte = xzCompressorInputStream.read();
        int secondByte = xzCompressorInputStream.read();
        int thirdByte = xzCompressorInputStream.read();
        int fourthByte = xzCompressorInputStream.read();
        int endByte = xzCompressorInputStream.read();
        assertEquals(1, firstByte);
        assertEquals(2, secondByte);
        assertEquals(3, thirdByte);
        assertEquals(4, fourthByte);
        assertEquals(-1, endByte);
    }

    @Test
    void testReadHandlesMemoryLimitException() throws IOException {
        InputStream inputStream = new InputStream() {

            @Override
            public int read() throws IOException {
                throw new org.tukaani.xz.MemoryLimitException(1024, 512);
            }
        };
        xzCompressorInputStream = new XZCompressorInputStream(inputStream);
        MemoryLimitException thrown = assertThrows(MemoryLimitException.class, () -> {
            xzCompressorInputStream.read();
        });
        assertNotNull(thrown);
        assertTrue(thrown.getMessage().contains("Memory needed: 1024"));
        assertTrue(thrown.getMessage().contains("Memory limit: 512"));
    }
}
