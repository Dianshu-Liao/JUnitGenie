package org.apache.commons.compress.compressors.z;

import org.apache.commons.compress.utils.BitInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ZCompressorInputStream_reAlignReading_5_0_Test {

    private ZCompressorInputStream zCompressorInputStream;

    private BitInputStream mockBitInputStream;

    @BeforeEach
    void setUp() throws IOException {
        InputStream mockInputStream = Mockito.mock(InputStream.class);
        mockBitInputStream = new BitInputStream(mockInputStream, ByteOrder.LITTLE_ENDIAN);
        zCompressorInputStream = new ZCompressorInputStream(mockInputStream);
    }

    private void setTotalCodesRead(long totalCodesRead) throws Exception {
        Field field = ZCompressorInputStream.class.getDeclaredField("totalCodesRead");
        field.setAccessible(true);
        field.set(zCompressorInputStream, totalCodesRead);
    }

    private void invokeReAlignReading() throws Exception {
        Method method = ZCompressorInputStream.class.getDeclaredMethod("reAlignReading");
        method.setAccessible(true);
        method.invoke(zCompressorInputStream);
    }

    @Test
    void testReAlignReading_NoCodesRead() throws Exception {
        setTotalCodesRead(0);
        assertDoesNotThrow(this::invokeReAlignReading);
        verify(mockBitInputStream, times(1)).clearBitCache();
    }

    @Test
    void testReAlignReading_EightCodesRead() throws Exception {
        setTotalCodesRead(8);
        assertDoesNotThrow(this::invokeReAlignReading);
        verify(mockBitInputStream, times(1)).clearBitCache();
    }

    @Test
    void testReAlignReading_SixCodesRead() throws Exception {
        setTotalCodesRead(6);
        assertDoesNotThrow(this::invokeReAlignReading);
        verify(mockBitInputStream, times(2)).clearBitCache();
    }

    @Test
    void testReAlignReading_FiveCodesRead() throws Exception {
        setTotalCodesRead(5);
        assertDoesNotThrow(this::invokeReAlignReading);
        verify(mockBitInputStream, times(3)).clearBitCache();
    }

    @Test
    void testReAlignReading_OneCodeRead() throws Exception {
        setTotalCodesRead(1);
        assertDoesNotThrow(this::invokeReAlignReading);
        verify(mockBitInputStream, times(7)).clearBitCache();
    }

    @Test
    void testReAlignReading_SeventeenCodesRead() throws Exception {
        setTotalCodesRead(17);
        assertDoesNotThrow(this::invokeReAlignReading);
        verify(mockBitInputStream, times(7)).clearBitCache();
    }

    @Test
    void testReAlignReading_NegativeCodesRead() throws Exception {
        setTotalCodesRead(-1);
        assertDoesNotThrow(this::invokeReAlignReading);
        verify(mockBitInputStream, times(7)).clearBitCache();
    }
}
