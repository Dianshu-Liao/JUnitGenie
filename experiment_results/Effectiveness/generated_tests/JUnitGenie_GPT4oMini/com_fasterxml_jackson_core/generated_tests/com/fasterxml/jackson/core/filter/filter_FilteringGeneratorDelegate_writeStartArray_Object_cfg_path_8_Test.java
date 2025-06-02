package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testWriteStartArrayWithIncludeAll() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = TokenFilter.INCLUDE_ALL;
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, true, false);
        Object forValue = new Object();

        // Act
        delegate.writeStartArray(forValue);

        // Assert
        verify(mockGenerator).writeStartArray(forValue);
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNonNullInclusion() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = mock(TokenFilter.class);
        TokenFilterContext mockContext = mock(TokenFilterContext.class);
        when(mockContext.checkValue(mockFilter)).thenReturn(mockFilter);
        when(mockFilter.filterStartArray()).thenReturn(mockFilter);
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, false);
        delegate._filterContext = mockContext;
        Object forValue = new Object();

        // Act
        delegate.writeStartArray(forValue);

        // Assert
        verify(mockGenerator).writeStartArray(forValue);
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, null, true, false);
        Object forValue = new Object();

        // Act
        delegate.writeStartArray(forValue);

        // Assert
        verify(mockGenerator, never()).writeStartArray(any());
    }


}