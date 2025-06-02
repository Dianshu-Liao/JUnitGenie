package org.apache.commons.compress.compressors;

import java.lang.reflect.Method;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class CompressorInputStream_count_0_2_Test {

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
    void testCountPositiveValue() throws Exception {
        invokeCountMethod(10);
        assertEquals(10, compressorInputStream.getCount());
    }

    @Test
    void testCountZeroValue() throws Exception {
        invokeCountMethod(0);
        assertEquals(0, compressorInputStream.getCount());
    }

    @Test
    void testCountNegativeValue() throws Exception {
        invokeCountMethod(-5);
        assertEquals(0, compressorInputStream.getCount());
    }

    private void invokeCountMethod(int value) throws Exception {
        Method countMethod = CompressorInputStream.class.getDeclaredMethod("count", long.class);
        countMethod.setAccessible(true);
        countMethod.invoke(compressorInputStream, (long) value);
    }
}
