package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartObject_Object_cfg_path_7_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;

        filteringGeneratorDelegate.writeStartObject(new Object());

        verify(mockTokenFilterContext).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNonNullFilter() throws IOException {
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartObject()).thenReturn(mockTokenFilter);

        filteringGeneratorDelegate._itemFilter = mockTokenFilter;

        filteringGeneratorDelegate.writeStartObject(new Object());

        verify(mockTokenFilterContext).createChildObjectContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNullFilter() throws IOException {
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(null);

        filteringGeneratorDelegate._itemFilter = mockTokenFilter;

        filteringGeneratorDelegate.writeStartObject(new Object());

        verify(mockTokenFilterContext).createChildObjectContext(null, false);
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNonNullInclusion() throws IOException {
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartObject()).thenReturn(mockTokenFilter);
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL;

        filteringGeneratorDelegate.writeStartObject(new Object());

        verify(mockTokenFilterContext).createChildObjectContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withFilteredOut() throws IOException {
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartObject()).thenReturn(null);
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;

        filteringGeneratorDelegate.writeStartObject(new Object());

        verify(mockTokenFilterContext).createChildObjectContext(mockTokenFilter, false);
    }

}