package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_14_Test {

    private TokenFilterContext tokenFilterContext;
    private JsonGenerator jsonGenerator;
    private TokenFilter tokenFilter;

    @Before
    public void setUp() throws Exception {
        // Using reflection to access the protected constructor
        tokenFilter = mock(TokenFilter.class);
        tokenFilterContext = (TokenFilterContext) TokenFilterContext.class.getDeclaredConstructor(int.class, TokenFilterContext.class, TokenFilter.class, boolean.class)
                .newInstance(0, null, tokenFilter, false);
        jsonGenerator = mock(JsonGenerator.class);
    }

    @Test(timeout = 4000)
    public void testCloseObjectWhenStartHandled() throws IOException, Exception {
        // Set _startHandled to true
        setField(tokenFilterContext, "_startHandled", true);

        // Call the method under test
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);

        // Verify that writeEndObject was called
        verify(jsonGenerator).writeEndObject();
        // Verify that the result is the parent context
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testCloseObjectWhenFilterIsNotIncludeAllAndIncludeEmptyObject() throws IOException, Exception {
        // Set up the filter to return true for includeEmptyObject
        when(tokenFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
        
        // Call the method under test
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);

        // Verify that writeStartObject and writeEndObject were called
        verify(jsonGenerator).writeStartObject();
        verify(jsonGenerator).writeEndObject();
        // Verify that the result is the parent context
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testCloseObjectWhenFilterIsNotIncludeAllAndNotIncludeEmptyObject() throws IOException, Exception {
        // Set up the filter to return false for includeEmptyObject
        when(tokenFilter.includeEmptyObject(anyBoolean())).thenReturn(false);
        
        // Call the method under test
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);

        // Verify that writeStartObject and writeEndObject were not called
        verify(jsonGenerator, never()).writeStartObject();
        verify(jsonGenerator, never()).writeEndObject();
        // Verify that the result is the parent context
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testCloseObjectWhenFilterIsIncludeAll() throws IOException, Exception {
        // Set the filter to INCLUDE_ALL
        setField(tokenFilterContext, "_filter", TokenFilter.INCLUDE_ALL);
        
        // Call the method under test
        TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);

        // Verify that filterFinishObject was called
        verify(tokenFilter).filterFinishObject();
        // Verify that the result is the parent context
        assertEquals(null, result);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

}