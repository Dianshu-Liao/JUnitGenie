package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import java.io.IOException;
import java.io.StringWriter;
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

class FilteringGeneratorDelegate_writeRaw_26_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        // Using the INCLUDE_ALL filter for testing
        mockTokenFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test
    void testWriteRawWithValidCharacter() throws IOException {
        // Valid character to write
        char c = 'A';
        filteringGeneratorDelegate.writeRaw(c);
        verify(mockJsonGenerator).writeRaw(c);
    }

    @Test
    void testWriteRawWhenCheckRawValueWriteReturnsFalse() throws IOException {
        // Mock the _itemFilter to return a filter that does not allow writing raw values
        TokenFilter mockFilter = mock(TokenFilter.class);
        when(mockFilter.includeRawValue()).thenReturn(false);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockFilter, true, true);
        // Should not call writeRaw on the delegate
        filteringGeneratorDelegate.writeRaw('A');
        verify(mockJsonGenerator, never()).writeRaw(anyChar());
    }

    @Test
    void testWriteRawWhenItemFilterIsNull() throws IOException {
        // Set the _itemFilter to null
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, true);
        // Should not call writeRaw on the delegate
        filteringGeneratorDelegate.writeRaw('A');
        verify(mockJsonGenerator, never()).writeRaw(anyChar());
    }

    // Additional test for private method _checkRawValueWrite
    @Test
    void testCheckRawValueWriteWithNullItemFilter() throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkRawValueWrite");
        method.setAccessible(true);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, true);
        boolean result = (boolean) method.invoke(filteringGeneratorDelegate);
        assertFalse(result);
    }

    @Test
    void testCheckRawValueWriteWithIncludeAll() throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkRawValueWrite");
        method.setAccessible(true);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, TokenFilter.INCLUDE_ALL, true, true);
        boolean result = (boolean) method.invoke(filteringGeneratorDelegate);
        assertTrue(result);
    }

    @Test
    void testCheckRawValueWriteWithCustomFilter() throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkRawValueWrite");
        method.setAccessible(true);
        TokenFilter mockFilter = mock(TokenFilter.class);
        when(mockFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockFilter, true, true);
        boolean result = (boolean) method.invoke(filteringGeneratorDelegate);
        assertTrue(result);
    }
}
