package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Field;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertSame;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_13_Test {

    private TokenFilterContext tokenFilterContext;
    private JsonGenerator jsonGenerator;
    private TokenFilter tokenFilter;
    private TokenFilterContext parentContext;

    @Before
    public void setUp() throws Exception {
        // Create a mock for JsonGenerator
        jsonGenerator = mock(JsonGenerator.class);
        
        // Create a mock for TokenFilter
        tokenFilter = mock(TokenFilter.class);
        
        // Create a parent context mock
        parentContext = mock(TokenFilterContext.class);
        
        // Use reflection to create an instance of TokenFilterContext
        tokenFilterContext = (TokenFilterContext) TokenFilterContext.class.getDeclaredConstructor(int.class, TokenFilterContext.class, TokenFilter.class, boolean.class)
                .newInstance(0, parentContext, tokenFilter, false);
    }

    @Test(timeout = 4000)
    public void testCloseObject_whenStartHandledIsFalseAndFilterIsNotNull() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Set the _startHandled to false
        Field startHandledField = tokenFilterContext.getClass().getDeclaredField("_startHandled");
        startHandledField.setAccessible(true);
        startHandledField.set(tokenFilterContext, false);
        
        // Set the _filter to a non-null value
        Field filterField = tokenFilterContext.getClass().getDeclaredField("_filter");
        filterField.setAccessible(true);
        filterField.set(tokenFilterContext, tokenFilter);
        
        // Mock the behavior of the filter
        when(tokenFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
        
        // Call the method under test
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);
        
        // Verify interactions
        verify(jsonGenerator).writeStartObject();
        verify(jsonGenerator).writeEndObject();
        verify(tokenFilter).filterFinishObject();
        
        // Assert that the parent context is returned
        assertSame(parentContext, result);
    }

}