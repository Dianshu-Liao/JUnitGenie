package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeString_char_____int_int_cfg_path_1_Test {

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
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteString_withValidParameters() throws IOException {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(anyString())).thenReturn(true);

        filteringGeneratorDelegate.writeString(text, offset, len);
        verify(mockJsonGenerator).writeString(text, offset, len);
    }

    @Test(timeout = 4000)
    public void testWriteString_withNullItemFilter() throws IOException {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        filteringGeneratorDelegate._itemFilter = null;

        filteringGeneratorDelegate.writeString(text, offset, len);
        verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

    @Test(timeout = 4000)
    public void testWriteString_withItemFilterExclusion() throws IOException {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(anyString())).thenReturn(false);

        filteringGeneratorDelegate.writeString(text, offset, len);
        verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

}