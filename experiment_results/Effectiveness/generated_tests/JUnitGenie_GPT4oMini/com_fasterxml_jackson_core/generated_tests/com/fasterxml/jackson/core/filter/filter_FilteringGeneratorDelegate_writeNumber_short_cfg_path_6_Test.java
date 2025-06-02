package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.mock;

public class filter_FilteringGeneratorDelegate_writeNumber_short_cfg_path_6_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNullItemFilter() throws IOException {
        // Set _itemFilter to null to cover the path where it returns early
        filteringGeneratorDelegate._itemFilter = null;

        try {
            filteringGeneratorDelegate.writeNumber((short) 5);
        } catch (IOException e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNonNullItemFilter() throws IOException {
        // Set _itemFilter to a non-null value
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;

        try {
            filteringGeneratorDelegate.writeNumber((short) 5);
        } catch (IOException e) {
            // Handle exception if necessary
        }
    }

}