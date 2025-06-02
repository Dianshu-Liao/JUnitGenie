package org.apache.commons.compress.compressors.lzma;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.compress.utils.OsgiUtils;

class LZMAUtils_internalIsLZMACompressionAvailable_5_0_Test {

    @Test
    void testInternalIsLZMACompressionAvailable_whenLZMACompressorInputStreamIsAvailable() throws Exception {
        // Using reflection to access the private method
        Method method = LZMAUtils.class.getDeclaredMethod("internalIsLZMACompressionAvailable");
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (Boolean) method.invoke(null);
        assertTrue(result, "LZMA compression should be available.");
    }

    @Test
    void testInternalIsLZMACompressionAvailable_whenLZMACompressorInputStreamIsNotAvailable() throws Exception {
        // Mock the LZMACompressorInputStream class to simulate NoClassDefFoundError
        Class<?> mockClass = Mockito.mock(Class.class);
        Mockito.when(mockClass.getDeclaredMethod("matches", Object.class, int.class)).thenThrow(new NoClassDefFoundError());
        // Using reflection to access the private method
        Method method = LZMAUtils.class.getDeclaredMethod("internalIsLZMACompressionAvailable");
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (Boolean) method.invoke(null);
        assertFalse(result, "LZMA compression should not be available when LZMACompressorInputStream is absent.");
    }
}
