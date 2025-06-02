// Test method
package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class FilteringGeneratorDelegate_writeBinary_30_1_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, null, true);
    }

    @Test
    public void testWriteBinary_WhenCheckBinaryWriteReturnsTrue_ShouldDelegateWriteBinary() throws Exception {
        // Fixed line
        Base64Variant base64Variant = Base64Variants.getDefaultVariant();
        byte[] data = new byte[] { 1, 2, 3, 4 };
        int offset = 0;
        int length = 4;
        // Use reflection to set the private method _checkBinaryWrite to return true
        setPrivateField(filteringGeneratorDelegate, "_checkBinaryWrite", true);
        // Act
        filteringGeneratorDelegate.writeBinary(base64Variant, data, offset, length);
        // Assert
        verify(mockJsonGenerator).writeBinary(eq(base64Variant), eq(data), eq(offset), eq(length));
    }

    @Test
    public void testWriteBinary_WhenCheckBinaryWriteReturnsFalse_ShouldNotDelegateWriteBinary() throws Exception {
        // Fixed line
        Base64Variant base64Variant = Base64Variants.getDefaultVariant();
        byte[] data = new byte[] { 1, 2, 3, 4 };
        int offset = 0;
        int length = 4;
        // Use reflection to set the private method _checkBinaryWrite to return false
        setPrivateField(filteringGeneratorDelegate, "_checkBinaryWrite", false);
        // Act
        filteringGeneratorDelegate.writeBinary(base64Variant, data, offset, length);
        // Assert
        verify(mockJsonGenerator, never()).writeBinary(any(), any(), anyInt(), anyInt());
    }

    private void setPrivateField(Object target, String fieldName, boolean value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setBoolean(target, value);
    }
}
