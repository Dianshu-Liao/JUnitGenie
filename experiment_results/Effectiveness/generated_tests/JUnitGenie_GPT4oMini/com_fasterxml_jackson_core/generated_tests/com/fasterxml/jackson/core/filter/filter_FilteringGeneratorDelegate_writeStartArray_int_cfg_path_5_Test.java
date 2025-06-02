package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeStartArray_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testWriteStartArray_withValidParameters() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, false);
        
        // Set up the necessary conditions
        delegate._filterContext = mockFilterContext;
        delegate._itemFilter = TokenFilter.INCLUDE_ALL; // This will satisfy the condition for INCLUDE_ALL

        int size = 5; // Valid integer for the size parameter

        // Act
        delegate.writeStartArray(size);

        // Assert
        verify(mockFilterContext).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockJsonGenerator).writeStartArray(size);
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, false);
        
        // Set up the necessary conditions
        delegate._filterContext = mockFilterContext;
        delegate._itemFilter = null; // This will trigger the null check

        int size = 5; // Valid integer for the size parameter

        // Act
        delegate.writeStartArray(size);

        // Assert
        verify(mockFilterContext).createChildArrayContext(null, false);
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNonNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, false);
        
        // Set up the necessary conditions
        delegate._filterContext = mockFilterContext;
        delegate._itemFilter = mockTokenFilter; // Non-null item filter

        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter); // Simulate checkValue returning a valid TokenFilter

        int size = 5; // Valid integer for the size parameter

        // Act
        delegate.writeStartArray(size);

        // Assert
        verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(size);
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withInclusionNonNull() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, false);
        
        // Set up the necessary conditions
        delegate._filterContext = mockFilterContext;
        delegate._itemFilter = mockTokenFilter; // Non-null item filter

        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter); // Simulate checkValue returning a valid TokenFilter

        int size = 5; // Valid integer for the size parameter

        // Act
        delegate.writeStartArray(size);

        // Assert
        verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(size);
    }


}