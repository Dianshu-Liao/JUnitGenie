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

class FilteringGeneratorDelegate_writeStartObject_9_0_Test {

    private JsonGenerator mockGenerator;

    private TokenFilter mockFilter;

    private TokenFilterContext mockContext;

    private FilteringGeneratorDelegate delegate;

    @BeforeEach
    void setUp() {
        mockGenerator = Mockito.mock(JsonGenerator.class);
        mockFilter = Mockito.mock(TokenFilter.class);
        mockContext = Mockito.mock(TokenFilterContext.class);
        delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
        // Set the mock context
        delegate._filterContext = mockContext;
    }

    @Test
    void testWriteStartObject_NullItemFilter() throws IOException {
        delegate._itemFilter = null;
        when(mockContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockContext);
        delegate.writeStartObject();
        verify(mockContext).createChildObjectContext(null, false);
        verifyNoMoreInteractions(mockGenerator);
    }

    @Test
    void testWriteStartObject_IncludeAllItemFilter() throws IOException {
        delegate._itemFilter = TokenFilter.INCLUDE_ALL;
        when(mockContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockContext);
        delegate.writeStartObject();
        verify(mockContext).createChildObjectContext(delegate._itemFilter, true);
        verify(mockGenerator).writeStartObject();
    }

    @Test
    void testWriteStartObject_FilterOut() throws IOException {
        delegate._itemFilter = mockFilter;
        when(mockContext.checkValue(mockFilter)).thenReturn(null);
        when(mockContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockContext);
        delegate.writeStartObject();
        verify(mockContext).checkValue(mockFilter);
        verify(mockContext).createChildObjectContext(null, false);
        verifyNoMoreInteractions(mockGenerator);
    }

    @Test
    void testWriteStartObject_FilterNonNull() throws IOException {
        delegate._itemFilter = mockFilter;
        when(mockContext.checkValue(mockFilter)).thenReturn(mockFilter);
        when(mockFilter.filterStartObject()).thenReturn(mockFilter);
        when(mockContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockContext);
        delegate.writeStartObject();
        verify(mockContext).checkValue(mockFilter);
        verify(mockFilter).filterStartObject();
        verify(mockContext).createChildObjectContext(mockFilter, true);
        verify(mockGenerator).writeStartObject();
    }

    @Test
    void testWriteStartObject_ExcludeNonNull() throws IOException {
        delegate._itemFilter = mockFilter;
        when(mockContext.checkValue(mockFilter)).thenReturn(mockFilter);
        when(mockContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockContext);
        delegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL;
        delegate.writeStartObject();
        verify(mockContext).checkValue(mockFilter);
        verify(mockFilter).filterStartObject();
        verify(mockContext).createChildObjectContext(mockFilter, true);
        verify(mockGenerator).writeStartObject();
    }

    @Test
    void testWriteStartObject_FilterNonMatching() throws IOException {
        delegate._itemFilter = mockFilter;
        when(mockContext.checkValue(mockFilter)).thenReturn(mockFilter);
        when(mockFilter.filterStartObject()).thenReturn(null);
        when(mockContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockContext);
        delegate.writeStartObject();
        verify(mockContext).checkValue(mockFilter);
        verify(mockFilter).filterStartObject();
        verify(mockContext).createChildObjectContext(mockFilter, false);
        verifyNoMoreInteractions(mockGenerator);
    }
}
