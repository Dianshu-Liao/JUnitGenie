package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_1_Test {

    private TokenFilterContext tokenFilterContext;
    private JsonGenerator jsonGenerator;
    private TokenFilter mockFilter;
    private TokenFilterContext mockParent;

    @Before
    public void setUp() throws Exception {
        // Create a mock JsonGenerator
        jsonGenerator = mock(JsonGenerator.class);
        
        // Create a mock TokenFilter
        mockFilter = mock(TokenFilter.class);
        
        // Create a mock parent TokenFilterContext
        mockParent = mock(TokenFilterContext.class);
        
        // Initialize the TokenFilterContext with necessary fields
        tokenFilterContext = new TokenFilterContext(0, mockParent, mockFilter, false);
        
        // Set the _startHandled field to false to cover the path
        setField(tokenFilterContext, "_startHandled", false);
        
        // Set the _filter field to a mock filter
        setField(tokenFilterContext, "_filter", mockFilter);
        
        // Set the _parent field to the mock parent
        setField(tokenFilterContext, "_parent", mockParent);
    }

    @Test(timeout = 4000)
    public void testCloseObject_WithEmptyObject() throws IOException {
        // Arrange
        when(mockFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
        doNothing().when(mockParent).writePath(jsonGenerator);
        
        // Act
        try {
            tokenFilterContext.closeObject(jsonGenerator);
        } catch (IOException e) {
            // Handle exception if needed
        }

        // Assert
        verify(mockParent).writePath(jsonGenerator);
        verify(jsonGenerator).writeStartObject();
        verify(jsonGenerator).writeEndObject();
        verify(mockFilter).filterFinishObject();
    }

    @Test(timeout = 4000)
    public void testCloseObject_WithNonEmptyObject() throws IOException {
        // Arrange
        when(mockFilter.includeEmptyObject(anyBoolean())).thenReturn(false);
        
        // Act
        try {
            tokenFilterContext.closeObject(jsonGenerator);
        } catch (IOException e) {
            // Handle exception if needed
        }

        // Assert
        verify(jsonGenerator, never()).writeStartObject();
        verify(jsonGenerator, never()).writeEndObject();
        verify(mockFilter).filterFinishObject();
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

}