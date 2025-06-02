package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertSame;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_9_Test {

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
        // Removed the assignment to _parent since it's final
        tokenFilterContext._filter = mockFilter;
        // tokenFilterContext._parent = mockParent; // This line is removed
        tokenFilterContext._startHandled = false;
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
            assertSame(mockParent, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseObject_WithFilterNotIncludeAll() throws IOException {
        // Arrange
        tokenFilterContext._filter = mockFilter;
        when(mockFilter.includeEmptyObject(anyBoolean())).thenReturn(false);
        
        // Act
        try {
            TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
            
            // Assert
            verify(mockFilter).filterFinishObject();
            assertSame(mockParent, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseObject_WhenStartHandled() throws IOException {
        // Arrange
        tokenFilterContext._startHandled = true;
        
        // Act
        try {
            TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
            
            // Assert
            verify(jsonGenerator).writeEndObject();
            assertSame(mockParent, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }


}