package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
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
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

class FilteringGeneratorDelegate_writeStartArray_4_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    void testWriteStartArray_WithNullItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeStartArray();
        verify(mockTokenFilterContext).createChildArrayContext(null, false);
        verifyNoMoreInteractions(mockJsonGenerator);
    }

    @Test
    void testWriteStartArray_WithIncludeAllItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeStartArray();
        verify(mockTokenFilterContext).createChildArrayContext(filteringGeneratorDelegate._itemFilter, true);
        verify(mockJsonGenerator).writeStartArray();
    }

    @Test
    void testWriteStartArray_WithFilteredItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
        filteringGeneratorDelegate.writeStartArray();
        verify(mockTokenFilterContext).checkValue(mockTokenFilter);
        verify(mockTokenFilter).filterStartArray();
        verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray();
    }

    @Test
    void testWriteStartArray_WithFilteredItemFilterAndNonNullInclusion() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._inclusion = Inclusion.INCLUDE_NON_NULL;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        filteringGeneratorDelegate.writeStartArray();
        verify(mockTokenFilterContext).checkValue(mockTokenFilter);
        verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray();
    }

    @Test
    void testWriteStartArray_WithFilteredItemFilterAndNoMatch() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate.writeStartArray();
        verify(mockTokenFilterContext).checkValue(mockTokenFilter);
        verify(mockTokenFilterContext).createChildArrayContext(null, false);
        verifyNoMoreInteractions(mockJsonGenerator);
    }

    @Test
    void testWriteStartArray_WithFilteredItemFilterAndNonIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartArray()).thenReturn(null);
        filteringGeneratorDelegate.writeStartArray();
        verify(mockTokenFilterContext).checkValue(mockTokenFilter);
        verify(mockTokenFilter).filterStartArray();
        verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, false);
        verifyNoMoreInteractions(mockJsonGenerator);
    }
}
