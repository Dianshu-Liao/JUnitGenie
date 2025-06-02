package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_long_cfg_path_1_Test {

    private JsonGenerator mockJsonGenerator;
    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter tokenFilter = TokenFilter.INCLUDE_ALL; // Using the public static field
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, tokenFilter, false, false);
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithIncludeAll() {
        long valueToWrite = 42L;

        try {
            filteringGeneratorDelegate.writeNumber(valueToWrite);
            verify(mockJsonGenerator).writeNumber(valueToWrite);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}