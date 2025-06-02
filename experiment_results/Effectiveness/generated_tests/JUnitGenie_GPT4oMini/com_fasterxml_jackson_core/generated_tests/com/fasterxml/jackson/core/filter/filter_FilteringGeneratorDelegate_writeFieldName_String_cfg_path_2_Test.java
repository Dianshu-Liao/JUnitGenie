package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeFieldName_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteFieldName_withValidName() throws JsonProcessingException, IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        
        String validName = "validFieldName"; // Non-null String valid for setting _currentName
        when(mockFilterContext.setFieldName(validName)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeProperty(validName)).thenReturn(mockTokenFilter);
        
        // Act
        delegate.writeFieldName(validName);

        // Assert
        verify(mockFilterContext).setFieldName(validName);
        verify(mockTokenFilter).includeProperty(validName);
        verify(mockJsonGenerator).writeFieldName(validName);
    }

    @Test(timeout = 4000)
    public void testWriteFieldName_withIncludeAll() throws JsonProcessingException, IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        
        String validName = "validFieldName"; // Non-null String valid for setting _currentName
        when(mockFilterContext.setFieldName(validName)).thenReturn(TokenFilter.INCLUDE_ALL);
        
        // Act
        delegate.writeFieldName(validName);

        // Assert
        verify(mockFilterContext).setFieldName(validName);
        verify(mockJsonGenerator).writeFieldName(validName);
    }

    @Test(timeout = 4000)
    public void testWriteFieldName_withNullName() throws JsonProcessingException, IOException {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        
        String nullName = null; // This should be handled

        // Act
        delegate.writeFieldName(nullName);

        // Assert
        verify(mockFilterContext).setFieldName(nullName);
        // No further actions expected since state should be null
    }

}