package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_2_Test {

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
    public void testCloseObject_withEmptyObject() throws IOException {
        // Arrange
        when(mockFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
        doNothing().when(mockParent).writePath(jsonGenerator); // Changed to public method
        
        // Act
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
        
        // Assert
        verify(mockParent).writePath(jsonGenerator); // Changed to public method
        verify(jsonGenerator).writeStartObject();
        verify(jsonGenerator).writeEndObject();
        assertEquals(mockParent, result); // Changed to assertEquals
    }

    @Test(timeout = 4000)
    public void testCloseObject_withNonEmptyObject() throws IOException {
        // Arrange
        when(mockFilter.includeEmptyObject(anyBoolean())).thenReturn(false);
        
        // Act
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
        
        // Assert
        verify(jsonGenerator, never()).writeStartObject();
        verify(jsonGenerator, never()).writeEndObject();
        assertEquals(mockParent, result); // Changed to assertEquals
    }

    @Test(timeout = 4000)
    public void testCloseObject_whenFilterIsIncludeAll() throws IOException, Exception { // Added Exception to the throws clause
        // Arrange
        setField(tokenFilterContext, "_filter", TokenFilter.INCLUDE_ALL);
        
        // Act
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
        
        // Assert
        verify(jsonGenerator, never()).writeStartObject();
        verify(jsonGenerator, never()).writeEndObject();
        assertEquals(mockParent, result); // Changed to assertEquals
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

}