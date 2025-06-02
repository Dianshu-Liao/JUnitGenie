package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeNumber_char_____int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteNumber_withValidParameters() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        delegate._itemFilter = TokenFilter.INCLUDE_ALL; // Set _itemFilter to INCLUDE_ALL
        delegate._filterContext = mockFilterContext; // Set _filterContext

        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        delegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator).writeNumber(encodedValueBuffer, offset, length);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, false);
        delegate._itemFilter = null; // Set _itemFilter to null

        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        delegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNonIncludeAllFilter() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        delegate._itemFilter = mockTokenFilter; // Set _itemFilter to a non-include-all filter
        delegate._filterContext = mockFilterContext; // Set _filterContext

        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(false); // Simulate non-inclusion

        // Act
        delegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withIncludeRawValueTrue() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        delegate._itemFilter = mockTokenFilter; // Set _itemFilter to a non-include-all filter
        delegate._filterContext = mockFilterContext; // Set _filterContext

        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(true); // Simulate inclusion

        // Act
        delegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator).writeNumber(encodedValueBuffer, offset, length);
    }


}