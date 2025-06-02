package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_2_Test {

    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;
    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithIncludeAll() {
        try {
            filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockTokenFilterContext).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNonNullInclusion() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
            filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL;
            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = null;
            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockTokenFilterContext).createChildArrayContext(null, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}