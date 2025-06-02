package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertSame;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_18_Test {

    private TokenFilterContext tokenFilterContext;
    private JsonGenerator jsonGenerator;
    private TokenFilter tokenFilter;

    @Before
    public void setUp() throws Exception {
        // Using reflection to create an instance of TokenFilterContext
        tokenFilterContext = (TokenFilterContext) TokenFilterContext.class.getDeclaredConstructor(int.class, TokenFilterContext.class, TokenFilter.class, boolean.class)
                .newInstance(0, null, null, false);
        
        // Mocking JsonGenerator
        jsonGenerator = mock(JsonGenerator.class);
        
        // Setting up the filter to be not INCLUDE_ALL
        tokenFilter = mock(TokenFilter.class);
        tokenFilterContext._filter = tokenFilter;
    }

    @Test(timeout = 4000)
    public void testCloseObject_whenStartHandledIsFalse_andFilterIsNotIncludeAll_andIncludeEmptyObjectReturnsTrue() throws IOException {
        // Arrange
        tokenFilterContext._startHandled = false;
        when(tokenFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
        
        // Act
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
        
        // Assert
        verify(jsonGenerator).writeStartObject();
        verify(jsonGenerator).writeEndObject();
        verify(tokenFilter).filterFinishObject();
        assertSame(tokenFilterContext._parent, result);
    }

    @Test(timeout = 4000)
    public void testCloseObject_whenStartHandledIsFalse_andFilterIsNotIncludeAll_andIncludeEmptyObjectReturnsFalse() throws IOException {
        // Arrange
        tokenFilterContext._startHandled = false;
        when(tokenFilter.includeEmptyObject(anyBoolean())).thenReturn(false);
        
        // Act
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
        
        // Assert
        verify(jsonGenerator, never()).writeStartObject();
        verify(jsonGenerator, never()).writeEndObject();
        verify(tokenFilter).filterFinishObject();
        assertSame(tokenFilterContext._parent, result);
    }

    @Test(timeout = 4000)
    public void testCloseObject_whenStartHandledIsTrue() throws IOException {
        // Arrange
        tokenFilterContext._startHandled = true;
        
        // Act
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
        
        // Assert
        verify(jsonGenerator).writeEndObject();
        verify(tokenFilter, never()).filterFinishObject();
        assertSame(tokenFilterContext._parent, result);
    }


}