package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_5_Test {

    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockItemFilter;
    private TokenFilterContext mockFilterContext;
    private FilteringGeneratorDelegate filteringDelegate;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockItemFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        filteringDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockItemFilter, true, true);
        filteringDelegate._filterContext = mockFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withValidForValue_andINCLUDE_ALL() throws IOException {
        // Arrange
        Object forValue = new Object(); // Non-null valid object
        filteringDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        
        // Act
        try {
            filteringDelegate.writeStartArray(forValue);
        } catch (Exception e) {
            // Handle exception if any
        }

        // Assert
        verify(mockFilterContext, times(1)).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockJsonGenerator, times(1)).writeStartArray(forValue);
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNonNullItemFilter() throws IOException {
        // Arrange
        Object forValue = new Object(); // Non-null valid object
        when(mockFilterContext.checkValue(mockItemFilter)).thenReturn(mockItemFilter);
        filteringDelegate._itemFilter = mockItemFilter;

        // Act
        try {
            filteringDelegate.writeStartArray(forValue);
        } catch (Exception e) {
            // Handle exception if any
        }

        // Assert
        verify(mockFilterContext, times(1)).checkValue(mockItemFilter);
        verify(mockFilterContext, times(1)).createChildArrayContext(mockItemFilter, true);
        verify(mockJsonGenerator, times(1)).writeStartArray(forValue);
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNullItemFilter() throws IOException {
        // Arrange
        Object forValue = new Object(); // Non-null valid object
        filteringDelegate._itemFilter = null;

        // Act
        try {
            filteringDelegate.writeStartArray(forValue);
        } catch (Exception e) {
            // Handle exception if any
        }

        // Assert
        verify(mockFilterContext, times(1)).createChildArrayContext(null, false);
        verify(mockJsonGenerator, never()).writeStartArray(any());
    }

}