package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
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

class FilteringGeneratorDelegate_writeString_16_2_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        // Use TokenFilter.INCLUDE_ALL
        mockTokenFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test
    void testWriteStringWithNullItemFilter() throws IOException {
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, false);
        assertDoesNotThrow(() -> filteringGeneratorDelegate.writeString("test"));
    }

    @Test
    void testWriteStringWithIncludeAllFilter() throws IOException {
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
    }

    @Test
    void testWriteStringWithNonMatchingFilter() throws IOException {
        TokenFilter nonMatchingFilter = new TokenFilter() {

            @Override
            public boolean includeString(String value) {
                // Simulate a filter that excludes all strings
                return false;
            }
        };
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, nonMatchingFilter, true, false);
        assertDoesNotThrow(() -> filteringGeneratorDelegate.writeString("test"));
        verify(mockJsonGenerator, never()).writeString(anyString());
    }

    @Test
    void testWriteStringWithMatchingFilter() throws IOException {
        TokenFilter matchingFilter = new TokenFilter() {

            @Override
            public boolean includeString(String value) {
                // Simulate a filter that includes all strings
                return true;
            }
        };
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, matchingFilter, true, false);
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
    }
}
