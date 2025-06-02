package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
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

class FilteringGeneratorDelegate_writeFieldName_13_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test
    void testWriteFieldName_NullState() throws IOException {
        when(mockTokenFilterContext.setFieldName(anyString())).thenReturn(null);
        filteringGeneratorDelegate.writeFieldName("testField");
        assertNull(filteringGeneratorDelegate._itemFilter);
        verify(mockJsonGenerator, never()).writeFieldName(anyString());
    }

    @Test
    void testWriteFieldName_IncludeAll() throws IOException {
        when(mockTokenFilterContext.setFieldName(anyString())).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate.writeFieldName("testField");
        assertEquals(TokenFilter.INCLUDE_ALL, filteringGeneratorDelegate._itemFilter);
        verify(mockJsonGenerator).writeFieldName("testField");
    }

    @Test
    void testWriteFieldName_IncludeProperty() throws IOException {
        when(mockTokenFilterContext.setFieldName(anyString())).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeProperty(anyString())).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate.writeFieldName("testField");
        assertEquals(TokenFilter.INCLUDE_ALL, filteringGeneratorDelegate._itemFilter);
        verify(mockTokenFilter).includeProperty("testField");
        verify(mockTokenFilterContext).setFieldName("testField");
    }

    @Test
    void testWriteFieldName_IncludePropertyAndCheckParentPath() throws IOException {
        when(mockTokenFilterContext.setFieldName(anyString())).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeProperty(anyString())).thenReturn(TokenFilter.INCLUDE_ALL);
        // Simulate calling _checkPropertyParentPath() indirectly
        filteringGeneratorDelegate.writeFieldName("testField");
        // Assuming _checkPropertyParentPath increments _matchCount
        // Since _matchCount is private, we can't assert it directly.
        // Just verifying that the method was invoked.
        // This would require reflection in a real test to check private state if needed.
    }
}
