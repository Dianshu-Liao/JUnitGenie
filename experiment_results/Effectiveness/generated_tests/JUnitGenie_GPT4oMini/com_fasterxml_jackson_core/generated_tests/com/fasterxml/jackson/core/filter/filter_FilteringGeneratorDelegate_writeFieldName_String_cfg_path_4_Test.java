package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class filter_FilteringGeneratorDelegate_writeFieldName_String_cfg_path_4_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator jsonGenerator;
    private TokenFilter tokenFilter;
    private TokenFilterContext tokenFilterContext;

    @Before
    public void setUp() {
        jsonGenerator = mock(JsonGenerator.class);
        tokenFilter = mock(TokenFilter.class);
        tokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(jsonGenerator, tokenFilter, true, false);
        filteringGeneratorDelegate._filterContext = tokenFilterContext; // Set the protected variable
    }

    @Test(timeout = 4000)
    public void testWriteFieldNameWithNullState() {
        String name = "testField";
        
        try {
            when(tokenFilterContext.setFieldName(name)).thenReturn(null);
            filteringGeneratorDelegate.writeFieldName(name);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteFieldNameWithIncludeAllState() {
        String name = "testField";
        
        try {
            when(tokenFilterContext.setFieldName(name)).thenReturn(TokenFilter.INCLUDE_ALL);
            filteringGeneratorDelegate.writeFieldName(name);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteFieldNameWithNonNullState() {
        String name = "testField";
        
        try {
            when(tokenFilterContext.setFieldName(name)).thenReturn(tokenFilter);
            when(tokenFilter.includeProperty(name)).thenReturn(tokenFilter);
            filteringGeneratorDelegate.writeFieldName(name);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}