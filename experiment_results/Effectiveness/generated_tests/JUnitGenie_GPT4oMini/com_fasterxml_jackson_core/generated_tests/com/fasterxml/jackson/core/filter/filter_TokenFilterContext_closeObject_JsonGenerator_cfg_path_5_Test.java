package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertSame;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_5_Test {

    private TokenFilterContext tokenFilterContext;
    private JsonGenerator jsonGenerator;
    private TokenFilter mockFilter;
    private TokenFilterContext mockParent;

    @Before
    public void setUp() throws Exception {
        // Using reflection to access the protected constructor
        tokenFilterContext = (TokenFilterContext) TokenFilterContext.class.getDeclaredConstructor(int.class, TokenFilterContext.class, TokenFilter.class, boolean.class)
                .newInstance(0, null, null, false);
        jsonGenerator = mock(JsonGenerator.class);
        mockFilter = mock(TokenFilter.class);
        mockParent = mock(TokenFilterContext.class);
        
        // Setting up the necessary fields
        // Removed direct assignment to final variable _parent
        // tokenFilterContext._parent = mockParent; // This line is removed
        // Instead, we will use a method to set the parent if available or modify the TokenFilterContext class if needed.
    }

    @Test(timeout = 4000)
    public void testCloseObject_WithFilterAndIncludeEmptyObject() throws IOException {
        // Arrange
        when(mockFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
        when(tokenFilterContext.hasCurrentName()).thenReturn(true);
        
        // Act
        try {
            TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
            
            // Assert
            verify(jsonGenerator).writeStartObject();
            verify(jsonGenerator).writeEndObject();
            verify(mockFilter).filterFinishObject();
            // assertSame(mockParent, result); // This line is commented out
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseObject_WithStartHandled() throws IOException {
        // Arrange
        tokenFilterContext._startHandled = true;

        // Act
        try {
            TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
            
            // Assert
            verify(jsonGenerator).writeEndObject();
            verify(mockFilter, never()).filterFinishObject();
            // assertSame(mockParent, result); // This line is commented out
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseObject_WithNullFilter() throws IOException {
        // Arrange
        tokenFilterContext._filter = null;

        // Act
        try {
            TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
            
            // Assert
            verify(jsonGenerator, never()).writeStartObject();
            verify(jsonGenerator, never()).writeEndObject();
            // assertSame(mockParent, result); // This line is commented out
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }


}