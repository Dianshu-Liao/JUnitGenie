package org.apache.commons.compress.compressors;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;

class CompressorInputStream_count_1_4_Test {

    private CompressorInputStream compressorInputStream;

    @BeforeEach
    void setUp() {
        compressorInputStream = Mockito.mock(CompressorInputStream.class, Mockito.withSettings().useConstructor().defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

    @Test
    void testCountWithPositiveRead() throws Exception {
        // Arrange
        long readValue = 10L;
        // Act
        invokeCount(readValue);
        // Assert
        assertEquals(readValue, compressorInputStream.getBytesRead());
    }

    @Test
    void testCountWithZeroRead() throws Exception {
        // Arrange
        long readValue = 0L;
        // Act
        invokeCount(readValue);
        // Assert
        assertEquals(0L, compressorInputStream.getBytesRead());
    }

    @Test
    void testCountWithNegativeRead() throws Exception {
        // Arrange
        long readValue = -1L;
        // Act
        invokeCount(readValue);
        // Assert
        assertEquals(0L, compressorInputStream.getBytesRead());
    }

    private void invokeCount(long read) throws Exception {
        Method countMethod = CompressorInputStream.class.getDeclaredMethod("count", long.class);
        countMethod.setAccessible(true);
        countMethod.invoke(compressorInputStream, read);
    }
}
