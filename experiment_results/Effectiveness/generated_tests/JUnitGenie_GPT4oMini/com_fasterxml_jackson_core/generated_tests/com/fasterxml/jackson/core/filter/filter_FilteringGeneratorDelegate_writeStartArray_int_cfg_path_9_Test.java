package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeStartArray_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testWriteStartArray() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = mock(TokenFilter.class);
        TokenFilterContext mockContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, Inclusion.INCLUDE_NON_NULL, false);
        
        // Set up the necessary conditions
        delegate._filterContext = mockContext;
        delegate._itemFilter = TokenFilter.INCLUDE_ALL; // This will trigger the INCLUDE_ALL path

        int size = 5; // Valid non-negative integer

        // Act
        delegate.writeStartArray(size);

        // Assert
        verify(mockContext).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockGenerator).writeStartArray(size);
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = mock(TokenFilter.class);
        TokenFilterContext mockContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, Inclusion.INCLUDE_NON_NULL, false);
        
        // Set up the necessary conditions
        delegate._filterContext = mockContext;
        delegate._itemFilter = null; // This will trigger the null item filter path

        int size = 5; // Valid non-negative integer

        // Act
        delegate.writeStartArray(size);

        // Assert
        verify(mockContext).createChildArrayContext(null, false);
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNonNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = mock(TokenFilter.class);
        TokenFilterContext mockContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, Inclusion.INCLUDE_NON_NULL, false);
        
        // Set up the necessary conditions
        delegate._filterContext = mockContext;
        delegate._itemFilter = mockFilter; // Non-null item filter

        int size = 5; // Valid non-negative integer

        when(mockContext.checkValue(mockFilter)).thenReturn(mockFilter); // Simulate checkValue returning the filter

        // Act
        delegate.writeStartArray(size);

        // Assert
        verify(mockContext).createChildArrayContext(mockFilter, true);
        verify(mockGenerator).writeStartArray(size);
    }


}