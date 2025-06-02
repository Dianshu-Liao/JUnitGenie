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

public class FilteringGeneratorDelegate_writeStartArray_6_0_Test {

    @Mock
    private JsonGenerator delegate;

    @Mock
    private TokenFilter rootFilter;

    @Mock
    private TokenFilter.Inclusion inclusion;

    @Mock
    private TokenFilterContext filterContext;

    @Mock
    private TokenFilter itemFilter;

    @InjectMocks
    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(delegate, rootFilter, inclusion, true);
    }

    @Test
    public void testWriteStartArray_itemFilterIsNull() throws IOException {
        filteringGeneratorDelegate.writeStartArray(new Object());
        assertNotNull(filteringGeneratorDelegate.getFilterContext());
        verify(filterContext).createChildArrayContext(null, false);
        verify(delegate, never()).writeStartArray(any());
    }

    @Test
    public void testWriteStartArray_itemFilterIsIncludeAll() throws IOException {
        when(itemFilter).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate._itemFilter = itemFilter;
        when(filterContext.createChildArrayContext(itemFilter, true)).thenReturn(filterContext);
        filteringGeneratorDelegate.writeStartArray(new Object());
        verify(filterContext).createChildArrayContext(itemFilter, true);
        verify(delegate).writeStartArray(any());
    }

    @Test
    public void testWriteStartArray_itemFilterIsCheckedNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = itemFilter;
        when(filterContext.checkValue(itemFilter)).thenReturn(null);
        when(filterContext.createChildArrayContext(null, false)).thenReturn(filterContext);
        filteringGeneratorDelegate.writeStartArray(new Object());
        assertNotNull(filteringGeneratorDelegate.getFilterContext());
        verify(filterContext).createChildArrayContext(null, false);
        verify(delegate, never()).writeStartArray(any());
    }

    @Test
    public void testWriteStartArray_itemFilterIsNotIncludeAll() throws IOException {
        when(filterContext.checkValue(itemFilter)).thenReturn(itemFilter);
        when(itemFilter.filterStartArray()).thenReturn(itemFilter);
        filteringGeneratorDelegate._itemFilter = itemFilter;
        filteringGeneratorDelegate.writeStartArray(new Object());
        verify(itemFilter).filterStartArray();
        verify(filterContext).createChildArrayContext(itemFilter, true);
        verify(delegate).writeStartArray(any());
    }

    @Test
    public void testWriteStartArray_inclusionIsIncludeNonNull() throws IOException {
        when(filterContext.checkValue(itemFilter)).thenReturn(itemFilter);
        when(itemFilter.filterStartArray()).thenReturn(itemFilter);
        filteringGeneratorDelegate._itemFilter = itemFilter;
        filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL;
        filteringGeneratorDelegate.writeStartArray(new Object());
        verify(filterContext).createChildArrayContext(itemFilter, true);
        verify(delegate).writeStartArray(any());
    }

    @Test
    public void testWriteStartArray_otherCases() throws IOException {
        when(filterContext.checkValue(itemFilter)).thenReturn(itemFilter);
        when(itemFilter.filterStartArray()).thenReturn(null);
        filteringGeneratorDelegate._itemFilter = itemFilter;
        filteringGeneratorDelegate.writeStartArray(new Object());
        verify(filterContext).createChildArrayContext(itemFilter, false);
        verify(delegate, never()).writeStartArray(any());
    }
}
