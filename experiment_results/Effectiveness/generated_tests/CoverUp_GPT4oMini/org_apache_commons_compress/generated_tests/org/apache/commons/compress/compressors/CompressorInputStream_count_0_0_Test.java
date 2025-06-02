package org.apache.commons.compress.compressors;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;

class CompressorInputStream_count_0_0_Test {

    private CompressorInputStream compressorInputStream;

    @BeforeEach
    void setUp() {
        compressorInputStream = new CompressorInputStream() {

            @Override
            public int read() {
                // Implementing abstract method
                return -1;
            }
        };
    }

    @Test
    void testCountWithPositiveRead() throws Exception {
        invokeCount(10);
        assertEquals(10, compressorInputStream.getBytesRead());
    }

    @Test
    void testCountWithZeroRead() throws Exception {
        invokeCount(0);
        assertEquals(0, compressorInputStream.getBytesRead());
    }

    @Test
    void testCountWithNegativeRead() throws Exception {
        invokeCount(-5);
        assertEquals(0, compressorInputStream.getBytesRead());
    }

    private void invokeCount(int read) throws Exception {
        Method method = CompressorInputStream.class.getDeclaredMethod("count", long.class);
        method.setAccessible(true);
        method.invoke(compressorInputStream, (long) read);
    }
}
