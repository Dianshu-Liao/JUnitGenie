package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeNumber_long_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() {
        // Arrange
        JsonGenerator mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = null; // _itemFilter is null
        TokenFilterContext mockFilterContext = Mockito.mock(TokenFilterContext.class);
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, false, false);
        delegate._filterContext = mockFilterContext; // Set the _filterContext

        long valueToWrite = 12345L;

        // Act
        try {
            delegate.writeNumber(valueToWrite);
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        // No exception should be thrown and the method should complete successfully
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withIncludeAllItemFilter() {
        // Arrange
        JsonGenerator mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = TokenFilter.INCLUDE_ALL; // _itemFilter is INCLUDE_ALL
        TokenFilterContext mockFilterContext = Mockito.mock(TokenFilterContext.class);
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, false, false);
        delegate._filterContext = mockFilterContext; // Set the _filterContext

        long valueToWrite = 12345L;

        // Act
        try {
            delegate.writeNumber(valueToWrite);
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        // No exception should be thrown and the method should complete successfully
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNonNullItemFilterAndNullCheckValue() {
        // Arrange
        JsonGenerator mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = new TokenFilter(); // _itemFilter is a new TokenFilter
        TokenFilterContext mockFilterContext = Mockito.mock(TokenFilterContext.class);
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, false, false);
        delegate._filterContext = mockFilterContext; // Set the _filterContext

        // Mock the behavior of checkValue to return null
        Mockito.when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(null);

        long valueToWrite = 12345L;

        // Act
        try {
            delegate.writeNumber(valueToWrite);
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        // No exception should be thrown and the method should complete successfully
    }

}