package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_short_cfg_path_1_Test {

    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        short valueToWrite = 123;

        // Act
        filteringGeneratorDelegate.writeNumber(valueToWrite);

        // Assert
        verify(mockJsonGenerator).writeNumber(valueToWrite);
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNonIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilter.includeNumber(anyShort())).thenReturn(true);
        short valueToWrite = 123;

        // Act
        filteringGeneratorDelegate.writeNumber(valueToWrite);

        // Assert
        verify(mockJsonGenerator).writeNumber(valueToWrite);
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNullItemFilter() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        short valueToWrite = 123;

        // Act
        filteringGeneratorDelegate.writeNumber(valueToWrite);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithExcludedValue() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilter.includeNumber(anyShort())).thenReturn(false);
        short valueToWrite = 123;

        // Act
        filteringGeneratorDelegate.writeNumber(valueToWrite);

        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

}