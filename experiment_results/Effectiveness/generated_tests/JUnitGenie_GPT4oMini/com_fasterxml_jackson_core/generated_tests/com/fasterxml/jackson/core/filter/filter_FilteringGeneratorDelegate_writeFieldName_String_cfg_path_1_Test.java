package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeFieldName_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteFieldName() {
        // Arrange
        JsonGenerator mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = Mockito.mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = Mockito.mock(TokenFilterContext.class);
        
        // Setting up the mock behavior
        try {
            Mockito.when(mockFilterContext.setFieldName(Mockito.anyString())).thenReturn(mockTokenFilter);
            Mockito.when(mockTokenFilter.includeProperty(Mockito.anyString())).thenReturn(mockTokenFilter);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        String fieldName = "testField";

        // Act
        try {
            delegate.writeFieldName(fieldName);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(mockFilterContext).setFieldName(fieldName);
            Mockito.verify(mockTokenFilter).includeProperty(fieldName);
            Mockito.verify(mockJsonGenerator).writeFieldName(fieldName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteFieldNameWithIncludeAll() {
        // Arrange
        JsonGenerator mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = Mockito.mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = Mockito.mock(TokenFilterContext.class);
        
        // Setting up the mock behavior
        try {
            Mockito.when(mockFilterContext.setFieldName(Mockito.anyString())).thenReturn(TokenFilter.INCLUDE_ALL);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        String fieldName = "testField";

        // Act
        try {
            delegate.writeFieldName(fieldName);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(mockFilterContext).setFieldName(fieldName);
            Mockito.verify(mockJsonGenerator).writeFieldName(fieldName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}