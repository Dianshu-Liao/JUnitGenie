package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_12_Test {

    private TokenFilterContext tokenFilterContext;
    private JsonGenerator jsonGenerator;
    private TokenFilter tokenFilter;

    @Before
    public void setUp() throws Exception {
        // Using reflection to access the protected constructor
        tokenFilterContext = (TokenFilterContext) TokenFilterContext.class.getDeclaredConstructor(int.class, TokenFilterContext.class, TokenFilter.class, boolean.class)
                .newInstance(0, null, TokenFilter.INCLUDE_ALL, false);
        jsonGenerator = mock(JsonGenerator.class);
        tokenFilter = mock(TokenFilter.class);
        
        // Setting up the necessary fields
        tokenFilterContext._startHandled = false; // Set to false to cover the path
        tokenFilterContext._filter = tokenFilter; // Assigning a mock filter
        // tokenFilterContext._parent is final, so we cannot assign to it.
    }

    @Test(timeout = 4000)
    public void testCloseObject() {
        try {
            tokenFilterContext.closeObject(jsonGenerator);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
        
        // Verify that the methods were called as expected
        try {
            verify(jsonGenerator, times(1)).writeStartObject();
            verify(jsonGenerator, times(1)).writeEndObject();
            verify(tokenFilter, times(1)).filterFinishObject();
        } catch (IOException e) {
            // Handle the exception if it occurs during verification
            e.printStackTrace();
        }
    }

}