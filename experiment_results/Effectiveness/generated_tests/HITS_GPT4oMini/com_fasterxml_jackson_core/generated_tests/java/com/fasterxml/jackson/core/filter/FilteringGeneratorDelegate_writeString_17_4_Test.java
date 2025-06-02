package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeString_17_4_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator jsonGenerator;

    private TokenFilter tokenFilter;

    private TokenFilterContext tokenFilterContext;

    @BeforeEach
    public void setUp() {
        jsonGenerator = mock(JsonGenerator.class);
        // Use the correct reference here
        tokenFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(jsonGenerator, tokenFilter, true, false);
        tokenFilterContext = mock(TokenFilterContext.class);
        when(tokenFilterContext.checkValue(tokenFilter)).thenReturn(tokenFilter);
        filteringGeneratorDelegate._filterContext = tokenFilterContext;
    }

    @Test
    public void testWriteStringWithIncludedFilter() throws IOException {
        char[] text = "test".toCharArray();
        assertDoesNotThrow(() -> filteringGeneratorDelegate.writeString(text, 0, text.length));
    }

    @Test
    public void testWriteStringWithNullFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeString("test".toCharArray(), 0, 4);
        // No exception should be thrown
    }

    @Test
    public void testWriteStringWithExcludedFilter() throws IOException {
        TokenFilter customFilter = new TokenFilter() {

            @Override
            public boolean includeString(String value) {
                // Exclude all strings
                return false;
            }
        };
        filteringGeneratorDelegate._itemFilter = customFilter;
        char[] text = "test".toCharArray();
        filteringGeneratorDelegate.writeString(text, 0, text.length);
        // No exception should be thrown
    }
}
