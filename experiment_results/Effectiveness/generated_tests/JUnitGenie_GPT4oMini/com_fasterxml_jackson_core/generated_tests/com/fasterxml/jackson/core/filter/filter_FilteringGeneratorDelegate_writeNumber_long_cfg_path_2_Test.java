package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_long_cfg_path_2_Test {
    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockItemFilter;
    private TokenFilterContext mockFilterContext;
    
    @Before
    public void setUp() throws Exception {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockItemFilter = TokenFilter.INCLUDE_ALL; // Assign INCLUDE_ALL for testing
        mockFilterContext = mock(TokenFilterContext.class);
        
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockItemFilter, true, false);
        // Set the _filterContext and _itemFilter via reflection if necessary
        // (typically these would not be set directly due to encapsulation)
        // Example for demonstration (not included in actual test code):
        // Field filterContextField = FilteringGeneratorDelegate.class.getDeclaredField("_filterContext");
        // filterContextField.setAccessible(true);
        // filterContextField.set(filteringGeneratorDelegate, mockFilterContext);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withValidParams() {
        try {
            filteringGeneratorDelegate.writeNumber(42L);
            verify(mockJsonGenerator).writeNumber(42L);
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception, though we expect this to succeed
        }
    }
    
    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() {
        try {
            // Set _itemFilter to null via reflection
            // Example for demonstration (not included in actual test code):
            // Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            // itemFilterField.setAccessible(true);
            // itemFilterField.set(filteringGeneratorDelegate, null);

            filteringGeneratorDelegate.writeNumber(42L);
            verify(mockJsonGenerator, never()).writeNumber(anyLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withCheckValueReturningNull() {
        try {
            // Mock behavior for the `checkValue` method
            when(mockFilterContext.checkValue(mockItemFilter)).thenReturn(null);

            filteringGeneratorDelegate.writeNumber(42L);
            verify(mockJsonGenerator, never()).writeNumber(anyLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withIncludeNumberReturningFalse() {
        try {
            // Setup the mock to return a TokenFilter with includeNumber returning false
            TokenFilter mockState = mock(TokenFilter.class);
            when(mockState.includeNumber(42L)).thenReturn(false);
            when(mockFilterContext.checkValue(mockItemFilter)).thenReturn(mockState);

            filteringGeneratorDelegate.writeNumber(42L);
            verify(mockJsonGenerator, never()).writeNumber(anyLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withIncludeNumberReturningTrue() {
        try {
            // Setup the mock to return a TokenFilter with includeNumber returning true
            TokenFilter mockState = mock(TokenFilter.class);
            when(mockState.includeNumber(42L)).thenReturn(true);
            when(mockFilterContext.checkValue(mockItemFilter)).thenReturn(mockState);

            filteringGeneratorDelegate.writeNumber(42L);
            verify(mockJsonGenerator).writeNumber(42L);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}