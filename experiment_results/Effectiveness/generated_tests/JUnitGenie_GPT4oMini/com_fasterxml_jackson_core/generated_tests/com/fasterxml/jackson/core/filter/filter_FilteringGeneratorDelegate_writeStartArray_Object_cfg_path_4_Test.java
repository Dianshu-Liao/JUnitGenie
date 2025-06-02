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

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_4_Test {

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
        delegate._filterContext = mockFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withValidTokenFilter() {
        try {
            // Setup the conditions for the test
            delegate._itemFilter = TokenFilter.INCLUDE_ALL;
            when(mockFilterContext.createChildArrayContext(any(), anyBoolean())).thenReturn(mockFilterContext);
            // Removed the return value for void method
            doNothing().when(mockJsonGenerator).writeStartArray(any());

            // Call the method under test
            delegate.writeStartArray(new Object());

            // Verify the interactions
            verify(mockFilterContext).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNullItemFilter() {
        try {
            // Setup the conditions for the test
            delegate._itemFilter = null;
            when(mockFilterContext.createChildArrayContext(any(), anyBoolean())).thenReturn(mockFilterContext);

            // Call the method under test
            delegate.writeStartArray(new Object());

            // Verify the interactions
            verify(mockFilterContext).createChildArrayContext(null, false);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNonNullInclusion() {
        try {
            // Setup the conditions for the test
            delegate._itemFilter = mockTokenFilter;
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockFilterContext.createChildArrayContext(any(), anyBoolean())).thenReturn(mockFilterContext);
            // Removed the return value for void method
            doNothing().when(mockJsonGenerator).writeStartArray(any());

            // Call the method under test
            delegate.writeStartArray(new Object());

            // Verify the interactions
            verify(mockFilterContext).checkValue(mockTokenFilter);
            verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}