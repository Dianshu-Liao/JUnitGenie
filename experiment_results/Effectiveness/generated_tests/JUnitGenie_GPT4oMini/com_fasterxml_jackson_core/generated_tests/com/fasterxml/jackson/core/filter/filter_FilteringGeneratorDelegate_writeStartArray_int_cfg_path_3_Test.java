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

public class filter_FilteringGeneratorDelegate_writeStartArray_int_cfg_path_3_Test {

    private FilteringGeneratorDelegate delegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, true);
        delegate._filterContext = mockFilterContext; // Set the mock filter context
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withValidTokenFilter() {
        try {
            // Setup the conditions for the test
            delegate._itemFilter = TokenFilter.INCLUDE_ALL; // Set _itemFilter to INCLUDE_ALL
            when(mockFilterContext.createChildArrayContext(any(TokenFilter.class), anyBoolean())).thenReturn(mockFilterContext);
            // Remove the return statement for void method
            doNothing().when(mockJsonGenerator).writeStartArray(anyInt());

            // Call the method under test
            delegate.writeStartArray(5);

            // Verify the interactions
            verify(mockFilterContext).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
            verify(mockJsonGenerator).writeStartArray(5);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNullItemFilter() {
        try {
            // Setup the conditions for the test
            delegate._itemFilter = null; // Set _itemFilter to null
            when(mockFilterContext.createChildArrayContext(any(TokenFilter.class), anyBoolean())).thenReturn(mockFilterContext);

            // Call the method under test
            delegate.writeStartArray(5);

            // Verify the interactions
            verify(mockFilterContext).createChildArrayContext(null, false);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNonNullItemFilter() {
        try {
            // Setup the conditions for the test
            delegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockFilterContext.createChildArrayContext(any(TokenFilter.class), anyBoolean())).thenReturn(mockFilterContext);
            // Remove the return statement for void method
            doNothing().when(mockJsonGenerator).writeStartArray(anyInt());

            // Call the method under test
            delegate.writeStartArray(5);

            // Verify the interactions
            verify(mockFilterContext).checkValue(mockTokenFilter);
            verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartArray(5);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}