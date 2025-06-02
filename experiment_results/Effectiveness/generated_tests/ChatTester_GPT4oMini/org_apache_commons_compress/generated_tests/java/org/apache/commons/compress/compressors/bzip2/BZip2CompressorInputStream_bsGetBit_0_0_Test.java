package org.apache.commons.compress.compressors.bzip2;

import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.CloseShieldInputStream;

class BZip2CompressorInputStream_bsGetBit_0_0_Test {

    private BZip2CompressorInputStream bzip2CompressorInputStream;

    private BitInputStream mockBitInputStream;

    @BeforeEach
    void setUp() throws IOException {
        InputStream mockInputStream = mock(InputStream.class);
        bzip2CompressorInputStream = new BZip2CompressorInputStream(mockInputStream);
        mockBitInputStream = mock(BitInputStream.class);
    }

    @Test
    void testBsGetBitReturnsTrue() throws Exception {
        // Setup the mock to return a value that results in true
        when(invokeBsR(mockBitInputStream, 1)).thenReturn(1);
        // Use reflection to access the private method
        boolean result = invokeBsGetBit(mockBitInputStream);
        assertTrue(result);
    }

    @Test
    void testBsGetBitReturnsFalse() throws Exception {
        // Setup the mock to return a value that results in false
        when(invokeBsR(mockBitInputStream, 1)).thenReturn(0);
        // Use reflection to access the private method
        boolean result = invokeBsGetBit(mockBitInputStream);
        assertFalse(result);
    }

    private boolean invokeBsGetBit(BitInputStream bin) throws Exception {
        java.lang.reflect.Method method = BZip2CompressorInputStream.class.getDeclaredMethod("bsGetBit", BitInputStream.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, bin);
    }

    private int invokeBsR(BitInputStream bin, int bits) throws Exception {
        java.lang.reflect.Method method = BZip2CompressorInputStream.class.getDeclaredMethod("bsR", BitInputStream.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(null, bin, bits);
    }
}
