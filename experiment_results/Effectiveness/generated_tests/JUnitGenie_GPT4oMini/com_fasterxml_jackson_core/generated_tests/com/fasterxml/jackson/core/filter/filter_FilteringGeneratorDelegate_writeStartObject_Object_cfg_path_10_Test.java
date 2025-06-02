package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartObject_Object_cfg_path_10_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, false, false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNonNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set a non-null item filter
            when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockTokenFilter.filterStartObject()).thenReturn(mockTokenFilter);
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withIncludeAll() {
        try {
            filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL; // Set item filter to INCLUDE_ALL
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNullCheckValue() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set a non-null item filter
            when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockTokenFilterContext).createChildObjectContext(null, false);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNonNullInclusion() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set a non-null item filter
            when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockTokenFilter.filterStartObject()).thenReturn(mockTokenFilter);
            filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL; // Set inclusion
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}