package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.math.BigDecimal;

public class filter_FilteringGeneratorDelegate_writeNumber_BigDecimal_cfg_path_6_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;

    @Before
    public void setUp() {
        mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        mockTokenFilter = Mockito.mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNullItemFilter() {
        try {
            // Set _itemFilter to null to cover the path where it returns early
            filteringGeneratorDelegate._itemFilter = null;
            filteringGeneratorDelegate.writeNumber(BigDecimal.TEN);
            // No exception should be thrown, and the method should return
        } catch (IOException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNonNullItemFilter() {
        try {
            // Set _itemFilter to a non-null value
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            Mockito.when(mockTokenFilter.includeNumber(Mockito.any(BigDecimal.class))).thenReturn(true);
            filteringGeneratorDelegate.writeNumber(BigDecimal.TEN);
            // No exception should be thrown, and the method should return
        } catch (IOException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}