package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartObject_Object_cfg_path_9_Test {

    private FilteringGeneratorDelegate delegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, true); // Updated to use Inclusion
        delegate._filterContext = mockFilterContext; // Set the mock filter context
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNonNullItemFilter() {
        try {
            delegate._itemFilter = TokenFilter.INCLUDE_ALL; // Set _itemFilter to INCLUDE_ALL
            delegate.writeStartObject(new Object());
            verify(mockFilterContext).createChildObjectContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNullItemFilter() {
        try {
            delegate._itemFilter = null; // Set _itemFilter to null
            delegate.writeStartObject(new Object());
            verify(mockFilterContext).createChildObjectContext(mockTokenFilter, false);
        } catch (IOException e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withFilteredItem() {
        try {
            delegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockTokenFilter.filterStartObject()).thenReturn(mockTokenFilter);
            delegate.writeStartObject(new Object());
            verify(mockFilterContext).createChildObjectContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withFilteredItemAndInclusion() {
        try {
            delegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockTokenFilter.filterStartObject()).thenReturn(mockTokenFilter);
            delegate._inclusion = Inclusion.INCLUDE_NON_NULL; // Set inclusion to INCLUDE_NON_NULL
            delegate.writeStartObject(new Object());
            verify(mockFilterContext).createChildObjectContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle the exception
        }
    }


}