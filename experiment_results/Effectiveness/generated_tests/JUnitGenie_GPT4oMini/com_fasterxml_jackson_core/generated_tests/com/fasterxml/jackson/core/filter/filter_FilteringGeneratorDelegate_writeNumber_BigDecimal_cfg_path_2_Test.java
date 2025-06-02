package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.math.BigDecimal;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_BigDecimal_cfg_path_2_Test {

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
    public void testWriteNumber_withNonNullItemFilterAndIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        BigDecimal value = BigDecimal.valueOf(10);

        filteringGeneratorDelegate.writeNumber(value);

        verify(mockJsonGenerator).writeNumber(value);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNonNullItemFilterAndCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        BigDecimal value = BigDecimal.valueOf(10);

        filteringGeneratorDelegate.writeNumber(value);

        verify(mockJsonGenerator, never()).writeNumber(eq(value)); // Specify the type explicitly
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNonNullItemFilterAndIncludeNumberReturnsFalse() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(false);
        BigDecimal value = BigDecimal.valueOf(10);

        filteringGeneratorDelegate.writeNumber(value);

        verify(mockJsonGenerator, never()).writeNumber(eq(value)); // Specify the type explicitly
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNonNullItemFilterAndIncludeNumberReturnsTrue() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(true);
        BigDecimal value = BigDecimal.valueOf(10);

        filteringGeneratorDelegate.writeNumber(value);

        verify(mockJsonGenerator).writeNumber(value);
    }


}