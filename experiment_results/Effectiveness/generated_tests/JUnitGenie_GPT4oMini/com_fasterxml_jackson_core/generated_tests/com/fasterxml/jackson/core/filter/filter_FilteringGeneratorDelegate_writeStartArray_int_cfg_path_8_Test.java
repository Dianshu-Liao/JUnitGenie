package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeStartArray_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testWriteStartArrayWithIncludeAll() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = TokenFilter.INCLUDE_ALL;
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, Inclusion.INCLUDE_NON_NULL, false);
        delegate._filterContext = mock(TokenFilterContext.class);
        delegate._itemFilter = mockFilter;

        // Act
        delegate.writeStartArray(5);

        // Assert
        verify(delegate._filterContext).createChildArrayContext(mockFilter, true);
        verify(mockGenerator).writeStartArray(5);
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNonNullInclusion() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = mock(TokenFilter.class); // Create a mock for TokenFilter
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, Inclusion.INCLUDE_NON_NULL, false);
        delegate._filterContext = mock(TokenFilterContext.class);
        delegate._itemFilter = mockFilter;

        when(delegate._filterContext.checkValue(mockFilter)).thenReturn(mockFilter);
        when(mockFilter.filterStartArray()).thenReturn(mockFilter);

        // Act
        delegate.writeStartArray(5);

        // Assert
        verify(delegate._filterContext).createChildArrayContext(mockFilter, true);
        verify(mockGenerator).writeStartArray(5);
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, null, Inclusion.INCLUDE_NON_NULL, false);
        delegate._filterContext = mock(TokenFilterContext.class);

        // Act
        delegate.writeStartArray(5);

        // Assert
        verify(delegate._filterContext).createChildArrayContext(null, false);
    }

}