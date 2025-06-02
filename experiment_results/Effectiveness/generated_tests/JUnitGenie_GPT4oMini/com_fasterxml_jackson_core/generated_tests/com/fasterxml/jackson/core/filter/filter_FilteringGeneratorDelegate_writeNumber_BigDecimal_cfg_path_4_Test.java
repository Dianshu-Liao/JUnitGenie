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

public class filter_FilteringGeneratorDelegate_writeNumber_BigDecimal_cfg_path_4_Test {

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
        
        // Set up the _itemFilter and _filterContext fields
        try {
            java.lang.reflect.Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            itemFilterField.setAccessible(true);
            itemFilterField.set(filteringGeneratorDelegate, mockTokenFilter);
            
            java.lang.reflect.Field filterContextField = FilteringGeneratorDelegate.class.getDeclaredField("_filterContext");
            filterContextField.setAccessible(true);
            filterContextField.set(filteringGeneratorDelegate, mockTokenFilterContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withValidInput() {
        BigDecimal validValue = BigDecimal.valueOf(10);
        
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
        when(mockTokenFilter.includeNumber(validValue)).thenReturn(true);

        try {
            filteringGeneratorDelegate.writeNumber(validValue);
            verify(mockJsonGenerator).writeNumber(eq(validValue)); // Specify the type explicitly
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() {
        try {
            java.lang.reflect.Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            itemFilterField.setAccessible(true);
            itemFilterField.set(filteringGeneratorDelegate, null);
            
            filteringGeneratorDelegate.writeNumber(BigDecimal.valueOf(10));
            verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class)); // Specify the type explicitly
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withExcludedNumber() {
        BigDecimal excludedValue = BigDecimal.valueOf(20);
        
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
        when(mockTokenFilter.includeNumber(excludedValue)).thenReturn(false);

        try {
            filteringGeneratorDelegate.writeNumber(excludedValue);
            verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class)); // Specify the type explicitly
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withCheckValueReturningNull() {
        BigDecimal validValue = BigDecimal.valueOf(30);
        
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);

        try {
            filteringGeneratorDelegate.writeNumber(validValue);
            verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class)); // Specify the type explicitly
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}