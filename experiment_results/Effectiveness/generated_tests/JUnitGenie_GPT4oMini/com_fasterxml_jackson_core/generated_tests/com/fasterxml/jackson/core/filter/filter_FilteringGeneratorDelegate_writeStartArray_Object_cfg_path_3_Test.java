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

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_3_Test {

    private FilteringGeneratorDelegate delegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = TokenFilter.INCLUDE_ALL; // Using the public static field
        mockFilterContext = mock(TokenFilterContext.class);
        delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, true);
        delegate._filterContext = mockFilterContext; // Set the mock filter context
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withValidTokenFilter() {
        try {
            // Setting up the mock behavior
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockFilterContext.createChildArrayContext(mockTokenFilter, true)).thenReturn(mockFilterContext);

            // Call the method under test
            delegate.writeStartArray(new Object());

            // Verify interactions
            verify(mockFilterContext).checkValue(mockTokenFilter);
            verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNullItemFilter() {
        try {
            delegate._itemFilter = null; // Set _itemFilter to null
            when(mockFilterContext.createChildArrayContext(null, false)).thenReturn(mockFilterContext);

            // Call the method under test
            delegate.writeStartArray(new Object());

            // Verify interactions
            verify(mockFilterContext).createChildArrayContext(null, false);
            verify(mockJsonGenerator, never()).writeStartArray(any()); // Should not call writeStartArray
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}