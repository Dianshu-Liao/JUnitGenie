package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeNumber_char_____int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteNumberWithValidParameters() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        delegate._filterContext = mockFilterContext;
        delegate._itemFilter = TokenFilter.INCLUDE_ALL;

        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);

        // Act
        delegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator).writeNumber(encodedValueBuffer, offset, length);
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, true);
        delegate._itemFilter = null;

        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        delegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNonIncludeAllFilter() throws IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        delegate._filterContext = mockFilterContext;
        delegate._itemFilter = mockTokenFilter;

        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(null);

        // Act
        delegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }


}