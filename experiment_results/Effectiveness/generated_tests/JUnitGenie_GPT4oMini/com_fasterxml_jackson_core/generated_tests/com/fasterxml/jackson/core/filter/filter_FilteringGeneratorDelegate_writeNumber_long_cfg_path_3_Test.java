package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_long_cfg_path_3_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        
        // Initialize FilteringGeneratorDelegate with mocked dependencies
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        
        // Set up the _filterContext field to return the mock context
        try {
            java.lang.reflect.Field field = FilteringGeneratorDelegate.class.getDeclaredField("_filterContext");
            field.setAccessible(true);
            field.set(filteringGeneratorDelegate, mockTokenFilterContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() {
        long value = 123L;

        // Set _itemFilter to null
        try {
            java.lang.reflect.Field field = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            field.setAccessible(true);
            field.set(filteringGeneratorDelegate, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            filteringGeneratorDelegate.writeNumber(value);
            verify(mockJsonGenerator, never()).writeNumber(anyLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
