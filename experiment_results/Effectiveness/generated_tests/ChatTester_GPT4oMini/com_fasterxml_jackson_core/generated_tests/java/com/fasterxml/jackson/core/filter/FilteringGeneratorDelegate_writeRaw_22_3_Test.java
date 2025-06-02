package com.fasterxml.jackson.core.filter;

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

class FilteringGeneratorDelegate_writeRaw_22_3_Test {

    private JsonGenerator mockJsonGenerator;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test
    void testWriteRaw_WhenCheckRawValueWriteReturnsTrue() throws Exception {
        // Arrange
        String rawText = "raw text";
        setCheckRawValueWriteReturnValue(true);
        // Act
        filteringGeneratorDelegate.writeRaw(rawText);
        // Assert
        verify(mockJsonGenerator).writeRaw(rawText);
    }

    @Test
    void testWriteRaw_WhenCheckRawValueWriteReturnsFalse() throws Exception {
        // Arrange
        String rawText = "raw text";
        setCheckRawValueWriteReturnValue(false);
        // Act
        filteringGeneratorDelegate.writeRaw(rawText);
        // Assert
        verify(mockJsonGenerator, never()).writeRaw(anyString());
    }

    private void setCheckRawValueWriteReturnValue(boolean returnValue) throws Exception {
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkRawValueWrite");
        method.setAccessible(true);
        when(method.invoke(filteringGeneratorDelegate)).thenReturn(returnValue);
    }
}
