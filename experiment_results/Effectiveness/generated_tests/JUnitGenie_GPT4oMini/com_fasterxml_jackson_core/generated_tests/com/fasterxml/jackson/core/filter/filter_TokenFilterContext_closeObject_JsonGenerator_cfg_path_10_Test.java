package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_10_Test {

    private TokenFilterContext tokenFilterContext;
    private JsonGenerator jsonGenerator;

    @Before
    public void setUp() throws Exception {
        // Using reflection to access the protected constructor
        tokenFilterContext = (TokenFilterContext) TokenFilterContext.class.getDeclaredConstructor(int.class, TokenFilterContext.class, TokenFilter.class, boolean.class)
                .newInstance(0, null, TokenFilter.INCLUDE_ALL, false);
        
        // Mocking JsonGenerator
        jsonGenerator = mock(JsonGenerator.class);
    }

    @Test(timeout = 4000)
    public void testCloseObjectWhenStartHandled() throws IOException {
        try {
            // Set _startHandled to true
            setField(tokenFilterContext, "_startHandled", true);

            // Call the method under test
            TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);

            // Verify that writeEndObject was called
            verify(jsonGenerator).writeEndObject();
            // Verify that the return value is the parent context
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseObjectWhenFilterIsNotIncludeAllAndIncludeEmptyObject() throws IOException {
        try {
            // Set up the filter and _startHandled
            TokenFilter mockFilter = mock(TokenFilter.class);
            when(mockFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
            setField(tokenFilterContext, "_filter", mockFilter);
            setField(tokenFilterContext, "_startHandled", false);

            // Call the method under test
            TokenFilterContext result = tokenFilterContext.closeObject(jsonGenerator);

            // Verify that the methods were called as expected
            verify(jsonGenerator).writeStartObject();
            verify(jsonGenerator).writeEndObject();
            verify(mockFilter).filterFinishObject();
            // Verify that the return value is the parent context
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

}