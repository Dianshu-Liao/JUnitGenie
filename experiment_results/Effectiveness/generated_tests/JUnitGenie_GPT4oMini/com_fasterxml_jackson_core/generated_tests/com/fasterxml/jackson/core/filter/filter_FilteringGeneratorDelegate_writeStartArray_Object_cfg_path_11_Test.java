package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_11_Test {

    private FilteringGeneratorDelegate delegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        delegate._filterContext = mockFilterContext; // Set the mock filter context
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNonNullItemFilter() {
        try {
            delegate._itemFilter = TokenFilter.INCLUDE_ALL; // Set _itemFilter to INCLUDE_ALL
            when(mockFilterContext.createChildArrayContext(any(), anyBoolean())).thenReturn(mockFilterContext);
            delegate.writeStartArray(new Object());
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNullItemFilter() {
        try {
            delegate._itemFilter = null; // Set _itemFilter to null
            when(mockFilterContext.createChildArrayContext(any(), anyBoolean())).thenReturn(mockFilterContext);
            delegate.writeStartArray(new Object());
            verify(mockFilterContext).createChildArrayContext(null, false);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withFilteredItem() {
        try {
            delegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockFilterContext.createChildArrayContext(any(), anyBoolean())).thenReturn(mockFilterContext);
            delegate.writeStartArray(new Object());
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}