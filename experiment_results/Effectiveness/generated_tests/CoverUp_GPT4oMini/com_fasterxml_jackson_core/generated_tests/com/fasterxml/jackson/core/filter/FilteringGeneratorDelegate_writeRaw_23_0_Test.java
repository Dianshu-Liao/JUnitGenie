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

public class FilteringGeneratorDelegate_writeRaw_23_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        // Using the static instance for simplicity
        mockTokenFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test
    public void testWriteRaw_WhenCheckRawValueWriteReturnsTrue_ShouldCallWriteRaw() throws Exception {
        // Arrange
        String text = "Test String";
        int offset = 0;
        int len = text.length();
        // Act
        invokeWriteRaw(text, offset, len);
        // Assert
        verify(mockJsonGenerator, times(1)).writeRaw(text, offset, len);
    }

    @Test
    public void testWriteRaw_WhenCheckRawValueWriteReturnsFalse_ShouldNotCallWriteRaw() throws Exception {
        // Arrange
        String text = "Test String";
        int offset = 0;
        int len = text.length();
        // Change the item filter to a value that will cause _checkRawValueWrite to return false
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, new TokenFilter(), true, true);
        // Act
        invokeWriteRaw(text, offset, len);
        // Assert
        verify(mockJsonGenerator, never()).writeRaw(anyString(), anyInt(), anyInt());
    }

    private void invokeWriteRaw(String text, int offset, int len) throws Exception {
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("writeRaw", String.class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(filteringGeneratorDelegate, text, offset, len);
    }

    @Test
    public void testCheckRawValueWrite_WhenItemFilterIsNull_ShouldReturnFalse() throws Exception {
        // Arrange
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, true);
        // Act
        boolean result = invokeCheckRawValueWrite();
        // Assert
        assertFalse(result);
    }

    @Test
    public void testCheckRawValueWrite_WhenItemFilterIsIncludeAll_ShouldReturnTrue() throws Exception {
        // Arrange
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, TokenFilter.INCLUDE_ALL, true, true);
        // Act
        boolean result = invokeCheckRawValueWrite();
        // Assert
        assertTrue(result);
    }

    private boolean invokeCheckRawValueWrite() throws Exception {
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkRawValueWrite");
        method.setAccessible(true);
        return (boolean) method.invoke(filteringGeneratorDelegate);
    }
}
