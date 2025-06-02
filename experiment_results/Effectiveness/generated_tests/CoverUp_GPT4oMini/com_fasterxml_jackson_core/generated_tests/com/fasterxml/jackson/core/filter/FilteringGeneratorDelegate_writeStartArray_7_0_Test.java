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

public class FilteringGeneratorDelegate_writeStartArray_7_0_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    public void testWriteStartArrayWithNullItemFilter() throws Exception {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeStartArray(new Object(), 5);
        verify(mockTokenFilterContext).createChildArrayContext(null, false);
    }

    @Test
    public void testWriteStartArrayWithIncludeAll() throws Exception {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        when(mockTokenFilterContext.createChildArrayContext(any(), any())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate.writeStartArray(new Object(), 5);
        verify(mockTokenFilterContext).createChildArrayContext(filteringGeneratorDelegate._itemFilter, true);
        verify(mockJsonGenerator).writeStartArray(any(), eq(5));
    }

    @Test
    public void testWriteStartArrayWithFilteredItem() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
        when(mockTokenFilterContext.createChildArrayContext(any(), any())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate.writeStartArray(new Object(), 5);
        verify(mockTokenFilterContext).checkValue(mockTokenFilter);
        verify(mockTokenFilter).filterStartArray();
        verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(any(), eq(5));
    }

    @Test
    public void testWriteStartArrayWithNullFilteredItem() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate.writeStartArray(new Object(), 5);
        verify(mockTokenFilterContext).checkValue(mockTokenFilter);
        verify(mockTokenFilterContext).createChildArrayContext(null, false);
    }

    @Test
    public void testWriteStartArrayWithNonNullInclusion() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilterContext.createChildArrayContext(any(), any())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate.writeStartArray(new Object(), 5);
        verify(mockTokenFilterContext).checkValue(mockTokenFilter);
        verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(any(), eq(5));
    }

    @Test
    public void testWriteStartArrayWithSkipParentChecks() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilterContext.createChildArrayContext(any(), any())).thenReturn(mockTokenFilterContext);
        doThrow(new IOException()).when(mockTokenFilterContext).createChildArrayContext(any(), any());
        assertThrows(IOException.class, () -> {
            filteringGeneratorDelegate.writeStartArray(new Object(), 5);
        });
    }

    // Reflection test to invoke private method _checkParentPath
    @Test
    public void testCheckParentPath() throws Exception {
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath", boolean.class);
        method.setAccessible(true);
        filteringGeneratorDelegate._matchCount = 0;
        method.invoke(filteringGeneratorDelegate, true);
        assertEquals(1, filteringGeneratorDelegate._matchCount);
    }
}
