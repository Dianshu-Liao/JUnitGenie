package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Field;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartObject_Object_cfg_path_11_Test {
    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockFilterContext;

    @Before
    public void setUp() throws Exception {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);

        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, TokenFilter.INCLUDE_ALL, true, false);
        // Set the _filterContext field via reflection as it's protected
        Field filterContextField = FilteringGeneratorDelegate.class.getDeclaredField("_filterContext");
        filterContextField.setAccessible(true);
        filterContextField.set(filteringGeneratorDelegate, mockFilterContext);
        // Set the _itemFilter field via reflection as it's protected
        Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
        itemFilterField.setAccessible(true);
        itemFilterField.set(filteringGeneratorDelegate, mockTokenFilter);
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withValidParams() {
        Object forValue = new Object();
        when(mockFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartObject()).thenReturn(mockTokenFilter);

        try {
            filteringGeneratorDelegate.writeStartObject(forValue);
            verify(mockJsonGenerator).writeStartObject(forValue);
        } catch (IOException e) {
            // Handle Exception
            e.printStackTrace(); // Or use an appropriate logger
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_when_itemFilterIsNull() {
        try {
            // Setting _itemFilter to null to test this condition
            Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            itemFilterField.setAccessible(true);
            itemFilterField.set(filteringGeneratorDelegate, null);

            filteringGeneratorDelegate.writeStartObject(new Object());
            // Verify that no interaction with jsonGenerator occurs
            verify(mockJsonGenerator, never()).writeStartObject(any(Object.class));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // Handle Exception
            e.printStackTrace(); // Or use an appropriate logger
        } catch (IOException e) {
            // Handle Exception
            e.printStackTrace(); // Or use an appropriate logger
        }
    }

}