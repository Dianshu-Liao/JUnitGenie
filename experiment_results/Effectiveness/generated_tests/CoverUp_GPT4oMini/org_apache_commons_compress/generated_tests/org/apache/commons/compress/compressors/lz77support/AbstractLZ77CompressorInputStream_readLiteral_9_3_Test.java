package org.apache.commons.compress.compressors.lz77support;

import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

class AbstractLZ77CompressorInputStream_readLiteral_9_3_Test {

    private AbstractLZ77CompressorInputStream compressorInputStream;

    @BeforeEach
    void setUp() {
        // Mock InputStream with some data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3, 4, 5 });
        compressorInputStream = new AbstractLZ77CompressorInputStream(inputStream, 4) {
        };
    }

    @Test
    void testReadLiteralWithSufficientData() throws Exception {
        byte[] buffer = new byte[3];
        int bytesRead = invokeReadLiteral(buffer, 0, 3);
        assertEquals(3, bytesRead);
        assertEquals(1, buffer[0]);
        assertEquals(2, buffer[1]);
        assertEquals(3, buffer[2]);
    }

    @Test
    void testReadLiteralWithInsufficientData() throws Exception {
        byte[] buffer = new byte[10];
        assertThrows(IOException.class, () -> invokeReadLiteral(buffer, 0, 10));
    }

    @Test
    void testReadLiteralWithExactBufferSize() throws Exception {
        byte[] buffer = new byte[5];
        int bytesRead = invokeReadLiteral(buffer, 0, 5);
        assertEquals(5, bytesRead);
        assertEquals(1, buffer[0]);
        assertEquals(2, buffer[1]);
        assertEquals(3, buffer[2]);
        assertEquals(4, buffer[3]);
        assertEquals(5, buffer[4]);
    }

    private int invokeReadLiteral(byte[] b, int off, int len) throws Exception {
        Method method = AbstractLZ77CompressorInputStream.class.getDeclaredMethod("readLiteral", byte[].class, int.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(compressorInputStream, b, off, len);
    }
}
