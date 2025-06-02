package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeBinary_30_0_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        mockTokenFilter = Mockito.mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, false, false);
    }

    @Test
    public void testWriteBinary_WithValidParameters() throws Exception {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
        int offset = 0;
        int length = data.length;
        // Mock behavior of _checkBinaryWrite to return true
        Method checkBinaryWriteMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkBinaryWrite");
        checkBinaryWriteMethod.setAccessible(true);
        Mockito.when(checkBinaryWriteMethod.invoke(filteringGeneratorDelegate)).thenReturn(true);
        filteringGeneratorDelegate.writeBinary(base64Variant, data, offset, length);
        verify(mockJsonGenerator).writeBinary(base64Variant, data, offset, length);
    }

    @Test
    public void testWriteBinary_WithBinaryWriteCheckFalse() throws Exception {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
        int offset = 0;
        int length = data.length;
        // Mock behavior of _checkBinaryWrite to return false
        Method checkBinaryWriteMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkBinaryWrite");
        checkBinaryWriteMethod.setAccessible(true);
        Mockito.when(checkBinaryWriteMethod.invoke(filteringGeneratorDelegate)).thenReturn(false);
        filteringGeneratorDelegate.writeBinary(base64Variant, data, offset, length);
        verify(mockJsonGenerator, Mockito.never()).writeBinary(Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void testWriteBinary_ThrowsIOException() throws Exception {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
        int offset = 0;
        int length = data.length;
        // Mock behavior of _checkBinaryWrite to return true
        Method checkBinaryWriteMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkBinaryWrite");
        checkBinaryWriteMethod.setAccessible(true);
        Mockito.when(checkBinaryWriteMethod.invoke(filteringGeneratorDelegate)).thenReturn(true);
        // Mock JsonGenerator to throw IOException
        doThrow(new IOException("Test Exception")).when(mockJsonGenerator).writeBinary(base64Variant, data, offset, length);
        assertThrows(IOException.class, () -> {
            filteringGeneratorDelegate.writeBinary(base64Variant, data, offset, length);
        });
    }
}
