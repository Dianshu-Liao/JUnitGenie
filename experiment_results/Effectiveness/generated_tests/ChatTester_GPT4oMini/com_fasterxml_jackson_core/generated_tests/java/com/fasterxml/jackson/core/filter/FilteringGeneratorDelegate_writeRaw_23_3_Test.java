package com.fasterxml.jackson.core.filter;

import java.io.IOException;
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

public class FilteringGeneratorDelegate_writeRaw_23_3_Test {

    private JsonGenerator mockDelegate;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockDelegate = mock(JsonGenerator.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockDelegate, null, null, true);
    }

    @Test
    public void testWriteRaw_WhenCheckRawValueWriteReturnsTrue_ShouldInvokeDelegate() throws IOException {
        // Arrange
        setPrivateField(filteringGeneratorDelegate, "_checkRawValueWrite", true);
        String text = "test";
        int offset = 0;
        int len = 4;
        // Act
        filteringGeneratorDelegate.writeRaw(text, offset, len);
        // Assert
        verify(mockDelegate).writeRaw(text, offset, len);
    }

    @Test
    public void testWriteRaw_WhenCheckRawValueWriteReturnsFalse_ShouldNotInvokeDelegate() throws IOException {
        // Arrange
        setPrivateField(filteringGeneratorDelegate, "_checkRawValueWrite", false);
        String text = "test";
        int offset = 0;
        int len = 4;
        // Act
        filteringGeneratorDelegate.writeRaw(text, offset, len);
        // Assert
        verify(mockDelegate, never()).writeRaw(anyString(), anyInt(), anyInt());
    }

    // Helper method to set private fields using reflection
    private void setPrivateField(Object target, String fieldName, boolean value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.setBoolean(target, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
