package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.math.BigDecimal;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_BigDecimal_cfg_path_3_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        
        // Initialize the FilteringGeneratorDelegate with mocked dependencies
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        
        // Set up the _filterContext field to return the mock context
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withValidInput() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL; // Set _itemFilter to INCLUDE_ALL
        BigDecimal value = new BigDecimal("123.45");

        // Act
        filteringGeneratorDelegate.writeNumber(value);

        // Assert
        verify(mockJsonGenerator).writeNumber(value);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNonIncludeAllFilter() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(true); // Simulate includeNumber returning true
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext; // Set the filter context

        BigDecimal value = new BigDecimal("123.45");

        // Act
        filteringGeneratorDelegate.writeNumber(value);

        // Assert
        verify(mockJsonGenerator).writeNumber(value);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null; // Set _itemFilter to null
        BigDecimal value = new BigDecimal("123.45");

        // Act
        filteringGeneratorDelegate.writeNumber(value);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class));
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withCheckValueReturningNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null); // Simulate checkValue returning null
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext; // Set the filter context

        BigDecimal value = new BigDecimal("123.45");

        // Act
        filteringGeneratorDelegate.writeNumber(value);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class));
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withIncludeNumberReturningFalse() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(false); // Simulate includeNumber returning false
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext; // Set the filter context

        BigDecimal value = new BigDecimal("123.45");

        // Act
        filteringGeneratorDelegate.writeNumber(value);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class));
    }

}