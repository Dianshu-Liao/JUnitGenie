package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_1_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        filteringGeneratorDelegate._filterContext = mockFilterContext; // Set the protected variable
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNullItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = null; // Set _itemFilter to null

        filteringGeneratorDelegate.writeStartArray(new Object());

        verify(mockFilterContext).createChildArrayContext(null, false);
        verifyNoMoreInteractions(mockJsonGenerator);
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithIncludeAllItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL; // Set _itemFilter to INCLUDE_ALL

        filteringGeneratorDelegate.writeStartArray(new Object());

        verify(mockFilterContext).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockJsonGenerator).writeStartArray(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNonNullInclusion() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
        filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL; // Set inclusion to INCLUDE_NON_NULL

        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockFilterContext.createChildArrayContext(mockTokenFilter, true)).thenReturn(mockFilterContext);

        filteringGeneratorDelegate.writeStartArray(new Object());

        verify(mockFilterContext).checkValue(mockTokenFilter);
        verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithFilteredItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
        filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL; // Set inclusion to INCLUDE_NON_NULL

        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
        when(mockFilterContext.createChildArrayContext(mockTokenFilter, true)).thenReturn(mockFilterContext);

        filteringGeneratorDelegate.writeStartArray(new Object());

        verify(mockFilterContext).checkValue(mockTokenFilter);
        verify(mockTokenFilter).filterStartArray();
        verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(any());
    }

}