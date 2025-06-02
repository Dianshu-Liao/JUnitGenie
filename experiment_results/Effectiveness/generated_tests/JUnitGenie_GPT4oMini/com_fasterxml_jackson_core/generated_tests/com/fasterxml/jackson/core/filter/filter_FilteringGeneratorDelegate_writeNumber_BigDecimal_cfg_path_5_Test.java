package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.math.BigDecimal;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_BigDecimal_cfg_path_5_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        
        // Set the protected fields using reflection
        try {
            java.lang.reflect.Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            itemFilterField.setAccessible(true);
            itemFilterField.set(filteringGeneratorDelegate, null); // Set _itemFilter to null

            java.lang.reflect.Field filterContextField = FilteringGeneratorDelegate.class.getDeclaredField("_filterContext");
            filterContextField.setAccessible(true);
            filterContextField.set(filteringGeneratorDelegate, mockTokenFilterContext); // Set _filterContext
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNullItemFilter() {
        try {
            filteringGeneratorDelegate.writeNumber(new BigDecimal("123.45"));
            // Verify that writeNumber was called on the delegate
            verify(mockJsonGenerator, times(1)).writeNumber(new BigDecimal("123.45"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}