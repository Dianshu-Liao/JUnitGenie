package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_long_cfg_path_4_Test {
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;
    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @Before
    public void setUp() {
        // Mock external dependencies
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        
        // Instantiate FilteringGeneratorDelegate
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        
        // Set the _filterContext to the mock context
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteNumber_whenItemFilterIsIncludeAll_shouldCallDelegateWriteNumber() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;

        // Act
        filteringGeneratorDelegate.writeNumber(10L);

        // Assert
        verify(mockJsonGenerator).writeNumber(10L);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_whenItemFilterIsNotIncludeAllAndCheckValueReturnsNonNull_shouldCallDelegateWriteNumber() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyLong())).thenReturn(true);

        // Act
        filteringGeneratorDelegate.writeNumber(10L);

        // Assert
        verify(mockJsonGenerator).writeNumber(10L);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_whenCheckValueReturnsNull_shouldNotCallDelegateWriteNumber() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(null);

        // Act
        filteringGeneratorDelegate.writeNumber(10L);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyLong());
    }

    @Test(timeout = 4000)
    public void testWriteNumber_whenIncludeNumberReturnsFalse_shouldNotCallDelegateWriteNumber() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyLong())).thenReturn(false);

        // Act
        filteringGeneratorDelegate.writeNumber(10L);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyLong());
    }

    @Test(timeout = 4000)
    public void testWriteNumber_whenItemFilterIsNull_shouldNotCallDelegateWriteNumber() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;

        // Act
        filteringGeneratorDelegate.writeNumber(10L);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyLong());
    }

}
