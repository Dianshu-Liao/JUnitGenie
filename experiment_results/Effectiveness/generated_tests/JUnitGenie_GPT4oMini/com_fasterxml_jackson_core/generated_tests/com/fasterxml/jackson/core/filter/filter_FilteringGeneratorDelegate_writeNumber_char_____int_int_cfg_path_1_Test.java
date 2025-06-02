package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_char_____int_int_cfg_path_1_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        
        // Initialize the FilteringGeneratorDelegate with mocked JsonGenerator and TokenFilter
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        
        // Assign _filterContext to the mockFilterContext
        filteringGeneratorDelegate._filterContext = mockFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteNumber_WithIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        char[] encodedValueBuffer = {'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        filteringGeneratorDelegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator).writeNumber(encodedValueBuffer, offset, length);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_WithNullItemFilter() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        char[] encodedValueBuffer = {'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        filteringGeneratorDelegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test(timeout = 4000)
    public void testWriteNumber_WithNonIncludeAllTokenFilter() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(false);
        
        char[] encodedValueBuffer = {'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        filteringGeneratorDelegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test(timeout = 4000)
    public void testWriteNumber_WithIncludeRawValueTrue() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        
        char[] encodedValueBuffer = {'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        filteringGeneratorDelegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator).writeNumber(encodedValueBuffer, offset, length);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_WhenCheckValueReturnsNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        
        char[] encodedValueBuffer = {'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        filteringGeneratorDelegate.writeNumber(encodedValueBuffer, offset, length);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

}