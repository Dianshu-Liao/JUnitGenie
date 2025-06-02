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

public class FilteringGeneratorDelegate_writeStartObject_10_0_Test {

    @Mock
    private JsonGenerator mockJsonGenerator;

    @Mock
    private TokenFilter mockTokenFilter;

    @Mock
    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    public void testWriteStartObject_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        when(mockTokenFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(null, false);
    }

    @Test
    public void testWriteStartObject_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        when(mockTokenFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(filteringGeneratorDelegate._itemFilter, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test
    public void testWriteStartObject_ItemFilterCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        when(mockTokenFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(null, false);
    }

    @Test
    public void testWriteStartObject_ItemFilterCheckValueReturnsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
        when(mockTokenFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test
    public void testWriteStartObject_ItemFilterCheckValueReturnsNonNullInclusion() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartObject()).thenReturn(mockTokenFilter);
        filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL;
        when(mockTokenFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test
    public void testWriteStartObject_ItemFilterCheckValueReturnsFilteredOut() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartObject()).thenReturn(null);
        when(mockTokenFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(mockTokenFilter, false);
    }
}
