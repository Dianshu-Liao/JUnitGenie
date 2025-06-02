package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartObject_Object_cfg_path_6_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, true); // Updated to use Inclusion
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNonNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockTokenFilterContext).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = null;
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockTokenFilterContext).createChildObjectContext(null, false);
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withValidTokenFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockTokenFilterContext).createChildObjectContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withFilteredToken() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockTokenFilterContext).createChildObjectContext(null, false);
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withInclusionNonNull() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            filteringGeneratorDelegate._inclusion = Inclusion.INCLUDE_NON_NULL; // Updated to use Inclusion
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockTokenFilterContext).createChildObjectContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle exception
        }
    }


}