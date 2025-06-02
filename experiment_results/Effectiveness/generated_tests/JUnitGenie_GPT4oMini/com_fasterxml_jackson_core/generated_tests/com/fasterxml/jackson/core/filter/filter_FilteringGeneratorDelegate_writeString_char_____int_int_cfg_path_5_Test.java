package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeString_char_____int_int_cfg_path_5_Test {

    private JsonGenerator mockJsonGenerator;
    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, TokenFilter.INCLUDE_ALL, false, false);
    }

    @Test(timeout = 4000)
    public void testWriteStringWithIncludeAll() {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        try {
            filteringGeneratorDelegate.writeString(text, offset, len);
            verify(mockJsonGenerator).writeString(text, offset, len);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}