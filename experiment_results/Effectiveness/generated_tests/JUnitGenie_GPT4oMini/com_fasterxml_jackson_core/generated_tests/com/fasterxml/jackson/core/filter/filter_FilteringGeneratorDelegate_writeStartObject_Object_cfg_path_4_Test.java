package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeStartObject_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteStartObjectWithIncludeAll() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = TokenFilter.INCLUDE_ALL;
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, true, false);
        Object forValue = new Object();

        // Act
        delegate.writeStartObject(forValue);

        // Assert
        verify(mockGenerator).writeStartObject(forValue);
    }

    @Test(timeout = 4000)
    public void testWriteStartObjectWithNonNullInclusion() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = new TokenFilter(); // Assuming a valid TokenFilter object
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, Inclusion.INCLUDE_NON_NULL, false);
        Object forValue = new Object();

        // Set up the _filterContext and _itemFilter to meet the constraints
        TokenFilterContext mockContext = mock(TokenFilterContext.class);
        when(mockContext.checkValue(mockFilter)).thenReturn(mockFilter);
        delegate._filterContext = mockContext;
        delegate._itemFilter = mockFilter;

        // Act
        delegate.writeStartObject(forValue);

        // Assert
        verify(mockGenerator).writeStartObject(forValue);
    }

    @Test(timeout = 4000)
    public void testWriteStartObjectWithNullFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, null, true, false);
        Object forValue = new Object();

        // Act
        delegate.writeStartObject(forValue);

        // Assert
        // No interaction with mockGenerator since _itemFilter is null
        verify(mockGenerator, never()).writeStartObject(any());
    }


}