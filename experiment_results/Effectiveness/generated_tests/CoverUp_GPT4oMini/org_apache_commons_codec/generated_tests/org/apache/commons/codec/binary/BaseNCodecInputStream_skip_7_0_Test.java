package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.commons.codec.binary.BaseNCodecInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseNCodecInputStream_skip_7_0_Test {

    private BaseNCodec baseNCodec;

    private BaseNCodecInputStream baseNCodecInputStream;

    @BeforeEach
    void setUp() throws Exception {
        // Create a BaseNCodec using reflection
        Constructor<BaseNCodec> constructor = BaseNCodec.class.getDeclaredConstructor(int.class, int.class, int.class, int.class);
        constructor.setAccessible(true);
        // Provide appropriate arguments as needed
        baseNCodec = constructor.newInstance(0, 0, 0, 0);
        // Mock BaseNCodec methods
        doAnswer(invocation -> {
            byte[] array = invocation.getArgument(0);
            int offset = invocation.getArgument(1);
            int length = invocation.getArgument(2);
            for (int i = 0; i < length; i++) {
                array[offset + i] = (byte) ('A' + (i % 26));
            }
            return length;
        }).when(baseNCodec).readResults(any(byte[].class), anyInt(), anyInt(), any(BaseNCodec.Context.class));
        // Create a BaseNCodecInputStream with a dummy input stream
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[1024]);
        baseNCodecInputStream = new BaseNCodecInputStream(inputStream, baseNCodec, false);
    }

    @Test
    void testSkipPositive() throws IOException {
        long skipped = baseNCodecInputStream.skip(100);
        assertEquals(100, skipped);
    }

    @Test
    void testSkipZero() throws IOException {
        long skipped = baseNCodecInputStream.skip(0);
        assertEquals(0, skipped);
    }

    @Test
    void testSkipNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            baseNCodecInputStream.skip(-1);
        });
        assertEquals("Negative skip length: -1", exception.getMessage());
    }

    @Test
    void testSkipMoreThanAvailableData() throws IOException {
        long skipped = baseNCodecInputStream.skip(2000);
        assertEquals(1024, skipped);
    }

    @Test
    void testSkipExactChunkSize() throws IOException {
        long skipped = baseNCodecInputStream.skip(512);
        assertEquals(512, skipped);
    }

    @Test
    void testSkipLessThanChunkSize() throws IOException {
        long skipped = baseNCodecInputStream.skip(256);
        assertEquals(256, skipped);
    }
}
