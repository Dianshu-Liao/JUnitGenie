package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeString_char_____int_int_cfg_path_2_Test {

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
    public void testWriteString_withValidParameters() {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        // Set up the mock behavior
        when(mockTokenFilter.includeString("test")).thenReturn(true); // Mocking the includeString method

        try {
            filteringGeneratorDelegate.writeString(text, offset, len);
            verify(mockJsonGenerator).writeString(text, offset, len);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteString_withItemFilterNotIncludeAll() {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        // Set up the mock behavior
        when(filteringGeneratorDelegate._itemFilter).thenReturn(mockTokenFilter);
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString("test")).thenReturn(false);

        try {
            filteringGeneratorDelegate.writeString(text, offset, len);
            verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteString_withNullItemFilter() {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        // Set up the mock behavior
        when(filteringGeneratorDelegate._itemFilter).thenReturn(null);

        try {
            filteringGeneratorDelegate.writeString(text, offset, len);
            verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}