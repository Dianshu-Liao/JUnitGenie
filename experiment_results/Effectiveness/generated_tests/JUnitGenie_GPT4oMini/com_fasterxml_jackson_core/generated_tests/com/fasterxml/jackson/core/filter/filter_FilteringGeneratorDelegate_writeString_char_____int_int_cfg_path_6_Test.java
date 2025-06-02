package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeString_char_____int_int_cfg_path_6_Test {
    private FilteringGeneratorDelegate delegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;

    @Before
    public void setup() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        // Initializes delegate with mock objects
        delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test(timeout = 4000)
    public void testWriteStringWithNullItemFilter() throws IOException {
        // Set _itemFilter to null
        delegate._itemFilter = null;
        
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        // Call the method under test
        delegate.writeString(text, offset, len);
        
        // Verify that writeString was never called on the delegate
        verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

}