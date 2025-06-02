package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.math.BigDecimal;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_BigDecimal_cfg_path_1_Test {

    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL; // Set _itemFilter to INCLUDE_ALL
        BigDecimal value = new BigDecimal("123.45");

        filteringGeneratorDelegate.writeNumber(value);

        verify(mockJsonGenerator).writeNumber(value); // Verify that writeNumber was called on the delegate
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNonNullItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(true); // Mock behavior

        BigDecimal value = new BigDecimal("123.45");
        filteringGeneratorDelegate.writeNumber(value);

        verify(mockJsonGenerator).writeNumber(value); // Verify that writeNumber was called on the delegate
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNullItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = null; // Set _itemFilter to null

        BigDecimal value = new BigDecimal("123.45");
        filteringGeneratorDelegate.writeNumber(value);

        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class)); // Verify that writeNumber was not called
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithExcludedValue() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter; // Set _itemFilter to a mock TokenFilter
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(false); // Mock behavior

        BigDecimal value = new BigDecimal("123.45");
        filteringGeneratorDelegate.writeNumber(value);

        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class)); // Verify that writeNumber was not called
    }

}