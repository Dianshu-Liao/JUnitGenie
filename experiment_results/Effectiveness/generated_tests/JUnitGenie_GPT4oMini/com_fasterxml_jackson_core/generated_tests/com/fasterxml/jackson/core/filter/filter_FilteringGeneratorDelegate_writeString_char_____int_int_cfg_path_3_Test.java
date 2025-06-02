package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeString_char_____int_int_cfg_path_3_Test {
    
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;
    private FilteringGeneratorDelegate filteringDelegate;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        filteringDelegate._filterContext = mockTokenFilterContext; // Setting the mocked context
    }

    @Test(timeout = 4000)
    public void testWriteString_ValidInput() {
        char[] text = "Hello".toCharArray();
        int offset = 0;
        int len = text.length;

        filteringDelegate._itemFilter = TokenFilter.INCLUDE_ALL; // Setting to INCLUDE_ALL

        try {
            filteringDelegate.writeString(text, offset, len);
            verify(mockJsonGenerator).writeString(text, offset, len); // Verify that writeString is called
        } catch (IOException e) {
            // Handle exception, though we expect this not to throw an exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteString_ItemFilterIsNull() {
        char[] text = "Hello".toCharArray();
        int offset = 0;
        int len = text.length;

        filteringDelegate._itemFilter = null; // Setting filter to null

        try {
            filteringDelegate.writeString(text, offset, len);
            verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteString_ItemFilterExcludesString() {
        char[] text = "Hello".toCharArray();
        int offset = 0;
        int len = text.length;

        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(anyString())).thenReturn(false); // It excludes the string

        filteringDelegate._itemFilter = mockTokenFilter; // Setting to a mock token filter

        try {
            filteringDelegate.writeString(text, offset, len);
            verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteString_CheckParentPathMethodCalled() {
        char[] text = "Hello".toCharArray();
        int offset = 0;
        int len = text.length;

        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(anyString())).thenReturn(true);
        
        // This will be called before delegate's writeString
        try {
            filteringDelegate.writeString(text, offset, len);
            verify(mockTokenFilterContext).checkValue(mockTokenFilter);
            // Verify that _checkParentPath is called
            // Change here: Use a spy to verify the method call on the filteringDelegate
            FilteringGeneratorDelegate spyDelegate = spy(filteringDelegate);
            spyDelegate.writeString(text, offset, len);
            verify(spyDelegate, times(1))._checkParentPath();
            verify(mockJsonGenerator).writeString(text, offset, len); // Check if the writeString is executed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}